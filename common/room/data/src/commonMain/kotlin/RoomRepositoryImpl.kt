import ktor.RoomKtorDataSource
import models.Room
import models.RoomRequest
import sqldelight.RoomSqlDelightDataSource

class RoomRepositoryImpl(
    private val authRepository: AuthRepository,
    private val roomKtorDataSource: RoomKtorDataSource,
    private val roomSqlDelightDataSource: RoomSqlDelightDataSource
):RoomRepository {
    override suspend fun addRoom(name: String, photo: String):String? {
        val token = authRepository.fetchToken() ?: return null
        val id = roomKtorDataSource.addRoom(RoomRequest(
            token = token,
            name = name,
            image = photo
        ))
        roomSqlDelightDataSource.cacheRoom(
            Room(
            id = id,
            name = name,
            login = token.login,
            image = photo
        ))
        return id
    }

    override suspend fun fetchRooms(forceReload:Boolean, from:Int, to:Int): List<Room> {
        val cachedRooms = roomSqlDelightDataSource.fetchRooms()
        println(cachedRooms)
        return if(cachedRooms.isNotEmpty() && !forceReload){
            cachedRooms
        }else{
            val token = authRepository.fetchToken() ?: return emptyList()

            roomSqlDelightDataSource.clearDatabase()
            roomKtorDataSource.fetchRooms(token, from, to).list.also {rooms ->
                rooms.forEach { room ->
                    roomSqlDelightDataSource.cacheRoom(room)
                }
            }
        }
    }

    override suspend fun fetchRoomPhotos(): List<String> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return roomKtorDataSource.fetchPhotos(token).list
    }
}