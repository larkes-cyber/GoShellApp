package models

import kotlinx.serialization.Serializable

@Serializable
data class AddRoomDeviceRequest(
    val token: TokenDTO,
    val typeId:String,
    val roomId:String,
    var name:String? = null
)