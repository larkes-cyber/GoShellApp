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

    override suspend fun fetchRooms(forceReload:Boolean): List<Room> {
        val cachedRooms = roomSqlDelightDataSource.fetchRooms()
        return if(cachedRooms.isNotEmpty() && !forceReload){
            println(cachedRooms)
            cachedRooms
        }else{
            println("authRepository.fetchToken() cccc ccc")
            val token = authRepository.fetchToken() ?: return emptyList()
            roomKtorDataSource.fetchRooms(token).list.also {rooms ->
                roomSqlDelightDataSource.clearDatabase()
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