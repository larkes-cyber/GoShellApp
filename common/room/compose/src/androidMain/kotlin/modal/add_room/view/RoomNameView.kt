package modal.add_room.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import modal.add_room.models.AddRoomEvent
import modal.add_room.models.AddRoomViewState

@Composable
fun RoomNameView(viewState: AddRoomViewState, viewEvent:(AddRoomEvent) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(horizontal = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Room Name",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value = viewState.name,
            onValueChange = {
                viewEvent(AddRoomEvent.NameChanged(it))
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Enter room name")
            }
        )
        Spacer(modifier = Modifier.height(25.dp))
        Button(
            onClick = {
                viewEvent(AddRoomEvent.ContinueClicked)
            },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(6.dp)
        ){
            Text("Continue")
        }
    }


}