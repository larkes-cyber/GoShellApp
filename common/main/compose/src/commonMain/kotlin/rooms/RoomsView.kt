package rooms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import rooms.models.RoomEvent
import rooms.models.RoomViewState

@Composable
fun RoomsView(
    state: RoomViewState, eventHandler: (RoomEvent) -> Unit
) {
    Text(state.toString())
}