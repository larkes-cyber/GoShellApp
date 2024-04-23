package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.path
import kotlinx.coroutines.delay
import models.Room
import models.RoomRequest
import models.RoomResponse
import models.TokenDTO

class RoomKtorDataSourceImpl(
    private val httpClient: HttpClient
):RoomKtorDataSource {
    override suspend fun addRoom(tokenDTO: TokenDTO, roomRequest: RoomRequest):String {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(RoomKtorDataSource.ADD_ROOM)
                setBody(roomRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
        return response.bodyAsText()
    }

    override suspend fun fetchRooms(tokenDTO: TokenDTO, count:Int): RoomResponse<Room> {
        val response = httpClient.post{
            delay(800)
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(RoomKtorDataSource.FETCH_ROOMS)
                parameters.append("count", count.toString())
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
        return response.body()
    }

    override suspend fun fetchPhotos(tokenDTO: TokenDTO): RoomResponse<String> {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(RoomKtorDataSource.FETCH_PHOTOS)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
        return response.body()
    }
}