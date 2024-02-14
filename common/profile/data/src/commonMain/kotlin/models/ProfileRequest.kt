package models

import kotlinx.serialization.Serializable

@Serializable
class ProfileRequest(
    val token:TokenDTO,
    val profile:Profile
)