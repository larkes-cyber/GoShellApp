package models

import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val id:String? = null,
    val image:String,
    val name:String,
    val login:String
)