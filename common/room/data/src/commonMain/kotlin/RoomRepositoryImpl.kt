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
        val id = roomKtorDataSource.addRoom(token, RoomRequest(
            name = name,
            image = photo
        ))
        roomSqlDelightDataSource.cacheRoom(
            Room(
                id = id,
                name = name,
                image = photo
        ))
        return id
    }

    override suspend fun fetchRooms(count:Int): List<Room> {

        val token = authRepository.fetchToken() ?: return emptyList()
        return try {
          val rooms = roomKtorDataSource.fetchRooms(token, count).list
          roomSqlDelightDataSource.clearDatabase()
          rooms.asReversed().forEach {
              roomSqlDelightDataSource.cacheRoom(it)
          }
          rooms
        }catch (e:Exception){
            val cachedRooms = roomSqlDelightDataSource.fetchRooms()
            cachedRooms.asReversed()
        }

    }

    override suspend fun fetchRoomPhotos(): List<String> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return roomKtorDataSource.fetchPhotos(token).list
    }
}