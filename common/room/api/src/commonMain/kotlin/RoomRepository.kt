import models.Room

interface RoomRepository {
    suspend fun addRoom(name:String, photo:String):String?
    suspend fun fetchRooms(forceReload:Boolean, from:Int, to:Int):List<Room>
    suspend fun fetchRoomPhotos():List<String>

}