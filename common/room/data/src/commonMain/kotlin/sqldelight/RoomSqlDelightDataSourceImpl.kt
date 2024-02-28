package sqldelight

import com.larkes.goshellapp.RoomDatabase
import models.Room
import kotlin.math.log

class RoomSqlDelightDataSourceImpl(
    private val db: RoomDatabase
):RoomSqlDelightDataSource {

    private val queries = db.roomEntityQueries
    override suspend fun cacheRoom(room: Room) {
        println(room.toString())
        queries.insertRoom(
            id = room.id!!,
            image = room.image,
            name = room.name,
            login = room.login
        )
    }

    override suspend fun fetchRooms(): List<Room> {
        println(queries.fetchRooms().executeAsList())
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