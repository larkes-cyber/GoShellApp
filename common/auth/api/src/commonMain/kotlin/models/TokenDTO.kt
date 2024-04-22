package models

import kotlinx.serialization.Serializable


@Serializable
data class TokenDTO(
    val token:String
)