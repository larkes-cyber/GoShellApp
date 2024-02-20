package sqldelight

import models.Room

interface RoomSqlDelightDataSource {
    suspend fun cacheRoom(room: Room)
    suspend fun fetchRooms():List<Room>
    suspend fun clearDatabase()
}