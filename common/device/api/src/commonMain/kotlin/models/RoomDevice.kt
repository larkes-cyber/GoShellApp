package models

import kotlinx.serialization.Serializable

@Serializable
data class RoomDevice(
    val id:String? = null,
    val typeId:String,
    val roomId:String,
    val login:String? = null,
    val active:Boolean = false,
    val icon:String? = null,
    var name:String? = null
)