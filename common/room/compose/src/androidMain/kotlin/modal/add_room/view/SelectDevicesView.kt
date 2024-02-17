package modal.add_room.view


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import modal.add_room.models.AddRoomEvent
import modal.add_room.models.AddRoomViewState

@Composable
fun SelectDevicesView(viewState: AddRoomViewState, viewEvent:(AddRoomEvent) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {

        viewState.fetchedDevices.forEach {
            SubcomposeAsyncImage(
                modifier = Modifier.clip(RoundedCornerShape(28.dp)).size(20.dp),
                model = it.icon,
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

        Button(
            onClick = {
                viewEvent(AddRoomEvent.ContinueClicked)
            }
        ){
            Text("Continue")
        }
    }

}