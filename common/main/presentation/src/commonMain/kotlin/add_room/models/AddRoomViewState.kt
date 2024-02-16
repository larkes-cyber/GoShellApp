package add_room.models

import models.Device

data class AddRoomViewState(
    val name:String = "",
    val selectedImage:String = "",
    val selectedDevices:List<Device> = listOf(),
    val fetchedImages:List<String> = listOf(),
    val fetchedDevices:List<Device> = listOf()
)