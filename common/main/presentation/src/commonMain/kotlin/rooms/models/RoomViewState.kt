package rooms.models

import kotlinx.serialization.Serializable

data class RoomViewState(
    val rooms:List<RoomWithDevices> = listOf(),
    val isLoading:Boolean = false
)