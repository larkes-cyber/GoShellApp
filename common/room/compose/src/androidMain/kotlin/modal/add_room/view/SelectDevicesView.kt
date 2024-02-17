package modal.add_room.view


import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle

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
import modal.add_room.models.AddRoomEvent
import modal.add_room.models.AddRoomViewState
import theme.Theme

@Composable
fun SelectDevicesView(viewState: AddRoomViewState, viewEvent:(AddRoomEvent) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
           items(viewState.fetchedDevices){device ->
               Box(
                   modifier = Modifier.clickable {
                       viewEvent(AddRoomEvent.DeviceSelected(device))
                   }
               ) {
                   Column {
                       SubcomposeAsyncImage(
                           modifier = Modifier.clip(RoundedCornerShape(28.dp)).size(20.dp),
                           model = device.icon,
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
                       Spacer(modifier = Modifier.height(15.dp))
                       Text(
                           text = device.name,
                           fontSize = 16.sp,
                           fontWeight = FontWeight.Medium,
                           color = Theme.colors.primaryColor
                       )
                   }
                   if(viewState.selectedDevices.contains(device)){
                       Box(
                           modifier = Modifier.align(Alignment.TopEnd).padding(end = 10.dp, top = 10.dp)
                       ) {
                           Icon(
                               imageVector = Icons.Rounded.CheckCircle,
                               contentDescription = null,
                               tint = Theme.colors.primaryColor,
                               modifier = Modifier.size(20.dp)
                           )
                       }
                   }
               }
           }
        }

        Button(
            onClick = {
                viewEvent(AddRoomEvent.ContinueClicked)
            }
        ){
            Text("Continue")
        }
    }

}