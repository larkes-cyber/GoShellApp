package rooms.models

sealed class RoomEvent {
    data object RoomClick:RoomEvent()
    data object AddRoomModalClick:RoomEvent()
    data object CloseAddRoomModal:RoomEvent()
    data object AddRoomClick:RoomEvent()
    data object Refresh:RoomEvent()
    data object NewRooms:RoomEvent()

}