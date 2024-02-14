package rooms.models

sealed class RoomEvent {
    data object RoomClick:RoomEvent()

}