package models

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id:String,
    val name:String,
    val login:String,
    var password:String
)