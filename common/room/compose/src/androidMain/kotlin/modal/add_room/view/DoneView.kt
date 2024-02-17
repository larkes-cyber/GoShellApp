package modal.add_room.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import modal.add_room.models.AddRoomEvent

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