package models

import kotlinx.serialization.Serializable

@Serializable
data class RoomRequest(
    val name:String,
    val image:String
)