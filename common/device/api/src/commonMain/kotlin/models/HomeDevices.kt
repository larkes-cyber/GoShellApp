package models

import kotlinx.serialization.Serializable

@Serializable
data class HomeDevices(
    val typeId:String,
    val name:String,
    val active:Int,
    val inactive:Int,
    val icon:String
)