import models.Room

interface RoomRepository {
    suspend fun addRoom(name:String, photo:String):String?
    suspend fun fetchRooms(count:Int):List<Room>
    suspend fun fetchRoomPhotos():List<String>

}