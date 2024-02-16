package add_room.views

import add_room.models.AddRoomEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DoneView(viewEvent:(AddRoomEvent) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Done")
        Button(
            onClick = {
                viewEvent(AddRoomEvent.ContinueClicked)
            }
        ){
            Text("Continue")
        }
    }
}