package models

import kotlinx.serialization.Serializable

@Serializable
data class RoomDevice(
    var id:String? = null,
    val typeId:String,
    val roomId:String,
    val active:Boolean = false,
    val icon:String? = null,
    var name:String? = null
)