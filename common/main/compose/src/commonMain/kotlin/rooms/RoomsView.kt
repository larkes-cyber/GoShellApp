package rooms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import home.models.HomeEvent
import home.models.HomeViewState
import rooms.models.RoomEvent
import rooms.models.RoomViewState

@Composable
fun RoomsView(
    state: RoomViewState, eventHandler: (RoomEvent) -> Unit
) {
    Text(state.toString())
}