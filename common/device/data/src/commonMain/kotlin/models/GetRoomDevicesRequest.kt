package models

import kotlinx.serialization.Serializable

@Serializable
data class GetRoomDevicesRequest(
    val roomId:String
)