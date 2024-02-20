package sqldelight

import com.larkes.goshellapp.common.core.GoShellDatabase
import models.Room
import kotlin.math.log

class RoomSqlDelightDataSourceImpl(
    private val db:GoShellDatabase
):RoomSqlDelightDataSource {

    private val queries = db.goShellDatabaseQueries
    override suspend fun cacheRoom(room: Room) {
        queries.insertRoom(
            id = room.id!!,
            image = room.image,
            name = room.name,
            login = room.login
        )
    }

    override suspend fun fetchRooms(): List<Room> {
        return queries.fetchRooms().executeAsList().map {
            Room(
                id = it.id,
                image = it.image,
                name = it.name,
                login = it.login
            )
        }
    }

    override suspend fun clearDatabase() {
        queries.removeAllRooms()
    }
}