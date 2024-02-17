package modal.add_room.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import modal.add_room.models.AddRoomEvent
import modal.add_room.models.AddRoomViewState

@Composable
fun RoomNameView(viewState: AddRoomViewState, viewEvent:(AddRoomEvent) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Room Name")

        TextField(
            value = viewState.name,
            onValueChange = {
                viewEvent(AddRoomEvent.NameChanged(it))
            }
        )

        Button(
            onClick = {
                viewEvent(AddRoomEvent.ContinueClicked)
            }
        ){
            Text("Continue")
        }
    }


}