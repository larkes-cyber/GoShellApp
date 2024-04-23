package rooms

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import rooms.models.RoomEvent
import rooms.models.RoomViewState

import theme.Theme

@Composable
fun RoomsView(
    state: RoomViewState, eventHandler: (RoomEvent) -> Unit
) {



    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.isLoading),
        onRefresh = {
            eventHandler(RoomEvent.Refresh)
        },
        indicatorPadding = PaddingValues(top = 70.dp),
        refreshTriggerDistance = 130.dp,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            ){
                Text(
                    text = "My Rooms",
                    color = Theme.colors.primaryColor,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Box(
                    modifier = Modifier
                        .size(26.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Theme.colors.primaryColor)
                        .clickable {
                            eventHandler(RoomEvent.AddRoomModalClick)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))


            if(state.rooms.isNotEmpty()) {
                LazyColumn(modifier = Modifier.padding(horizontal = 15.dp)) {
                    items(state.rooms){
                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Column {
                                AsyncImage(
                                    model = it.image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(160.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Row(
                                    modifier = Modifier.padding(top = 10.dp, bottom = 15.dp, start = 20.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = it.name,
                                        fontSize = 18.sp,
                                        color = Theme.colors.primaryColor
                                    )
                                    Spacer(modifier = Modifier.width(25.dp))
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                                        modifier = Modifier.padding(top = 3.dp)
                                    ) {
                                        it.devices.forEach {device ->
                                            SubcomposeAsyncImage(
                                                modifier = Modifier.clip(RoundedCornerShape(28.dp)).size(20.dp),
                                                model = device,
                                                contentScale = ContentScale.FillBounds,
                                                contentDescription = "Avatar",
                                                loading = {
                                                    Box(
                                                        modifier = Modifier.fillMaxSize(),
                                                        contentAlignment = Alignment.Center
                                                    ){
                                                        Box(modifier = Modifier.size(25.dp)) {
                                                            CircularProgressIndicator()
                                                        }
                                                    }

                                                }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    item {
                        if(state.paginingHidden.not()) {
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.onFocusEvent {
                                        eventHandler(RoomEvent.NewRooms)
                                    }
                                )
                            }
                        }
                    }
                }
            }else{
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }


}