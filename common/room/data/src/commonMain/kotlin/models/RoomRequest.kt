package models

import kotlinx.serialization.Serializable

@Serializable
data class RoomRequest(
    val token:TokenDTO,
    val name:String,
    val image:String
)