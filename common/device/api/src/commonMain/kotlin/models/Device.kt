package models

import kotlinx.serialization.Serializable

@Serializable
data class Device(
    val id:String,
    val name:String,
    val icon:String
)