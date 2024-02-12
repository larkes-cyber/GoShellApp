package models

import kotlinx.serialization.Serializable

@Serializable
data class DeviceActiveRequest(
    val token:TokenDTO,
    val id:String
)