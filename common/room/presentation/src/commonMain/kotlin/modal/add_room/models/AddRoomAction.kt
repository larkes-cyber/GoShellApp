package modal.add_room.models

sealed class AddRoomAction {

    data object OpenRoomName:AddRoomAction()
    data object OpenSelectImage:AddRoomAction()
    data object OpenSelectDevices:AddRoomAction()
    data object OpenDone:AddRoomAction()
    data object OpenRoomScreen:AddRoomAction()

}