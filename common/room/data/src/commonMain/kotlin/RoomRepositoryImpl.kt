import ktor.RoomKtorDataSource
import models.Room
import models.RoomRequest

class RoomRepositoryImpl(
    private val authRepository: AuthRepository,
    private val roomKtorDataSource: RoomKtorDataSource
):RoomRepository {
    override suspend fun addRoom(name: String, photo: String):String? {
        val token = authRepository.fetchToken() ?: return null
        return roomKtorDataSource.addRoom(RoomRequest(
            token = token,
            name = name,
            image = photo
        ))
    }

    override suspend fun fetchRooms(): List<Room> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return roomKtorDataSource.fetchRooms(token).rooms
    }

    override suspend fun fetchRoomPhotos(): List<String> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return roomKtorDataSource.fetchPhotos(token).rooms
    }
}