package models

import kotlinx.serialization.Serializable


@Serializable
data class TokenDTO(
    val login:String,
    val token:String
)