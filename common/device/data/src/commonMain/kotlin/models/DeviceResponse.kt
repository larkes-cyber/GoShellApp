package models

import kotlinx.serialization.Serializable

@Serializable
data class DeviceResponse<T>(
    val devices:List<T>
)