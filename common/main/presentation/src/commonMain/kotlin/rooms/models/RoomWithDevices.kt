package rooms.models

data class RoomWithDevices(
    val name:String,
    val image:String,
    val devices:List<String>
)