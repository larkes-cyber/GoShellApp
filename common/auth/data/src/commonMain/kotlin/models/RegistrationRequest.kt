package models

import kotlinx.serialization.Serializable

@Serializable
class RegistrationRequest(
    val login:String,
    val password:String,
    val name:String
)