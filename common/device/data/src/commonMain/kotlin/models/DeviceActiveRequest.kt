package models

import kotlinx.serialization.Serializable

@Serializable
data class DeviceActiveRequest(
    val id:String
)