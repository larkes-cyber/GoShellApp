package rooms.models

sealed class RoomAction {
    data object OpenRoomDetail:RoomAction()
    data object OpenAddRoom:RoomAction()
    data object OpenRooms:RoomAction()
}