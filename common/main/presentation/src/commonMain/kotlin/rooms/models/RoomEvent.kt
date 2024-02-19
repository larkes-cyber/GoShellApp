package rooms.models

sealed class RoomEvent {
    data object RoomClick:RoomEvent()
    data object AddRoomModalClick:RoomEvent()
    data object CloseAddRoomModal:RoomEvent()
    data object AddRoomClick:RoomEvent()

}