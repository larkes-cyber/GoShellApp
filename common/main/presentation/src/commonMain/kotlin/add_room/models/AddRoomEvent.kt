package add_room.models

import models.Device

sealed class AddRoomEvent {
    data class NameChanged(val value:String):AddRoomEvent()
    data class ImageSelected(val value:String):AddRoomEvent()
    data class DeviceSelected(val value:Device):AddRoomEvent()
    data object ContinueClicked:AddRoomEvent()
}