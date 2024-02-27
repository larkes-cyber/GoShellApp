package ktor

import models.Room
import models.RoomRequest
import models.RoomResponse
import models.TokenDTO

interface RoomKtorDataSource {
    suspend fun addRoom(roomRequest: RoomRequest):String
    suspend fun fetchRooms(tokenDTO: TokenDTO, count:Int):RoomResponse<Room>
    suspend fun fetchPhotos(tokenDTO: TokenDTO):RoomResponse<String>

    companion object{

        const val ADD_ROOM = "room/add"
        const val FETCH_ROOMS = "room/get"
        const val FETCH_PHOTOS = "room/getPhotos"

    }

}