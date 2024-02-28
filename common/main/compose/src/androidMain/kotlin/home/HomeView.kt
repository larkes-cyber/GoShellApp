package home

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import home.models.HomeEvent
import home.models.HomeViewState
import theme.Theme

@Composable
fun HomeView(state: HomeViewState, eventHandler: (HomeEvent) -> Unit) {


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(top = 25.dp)
    ) {
        Text(
            text = "My Home",
            color = Theme.colors.primaryColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 14.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        println(state.homeDevices)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            item {
                Spacer(modifier = Modifier.width(8.dp))
            }
            items(state.homeDevices){homeDevice ->
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(Theme.colors.subgroundColor)
                        .padding(vertical = 10.dp)
                        .padding(horizontal = 15.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)

                ) {
                   Box(
                       modifier = Modifier
                           .size(22.dp)
                           .clip(RoundedCornerShape(100))
                           .background(Color.White),
                       contentAlignment = Alignment.Center
                   ) {
                       SubcomposeAsyncImage(
                           modifier = Modifier.size(16.dp),
                           model = homeDevice.icon,
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
                    Column {
                        Text(
                            text = homeDevice.name,
                            color = Theme.colors.primaryTextColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "${homeDevice.active} Active",
                            color = Theme.colors.primaryTextColor,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}