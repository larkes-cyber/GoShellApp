package models

import kotlinx.serialization.Serializable

@Serializable
data class GetRoomDevicesRequest(
    val token:TokenDTO,
    val roomId:String
)