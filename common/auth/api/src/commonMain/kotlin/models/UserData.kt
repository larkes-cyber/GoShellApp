package models

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val login:String,
    val password:String
)