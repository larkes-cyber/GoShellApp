package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
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
    override suspend fun addRoom(roomRequest: RoomRequest):String {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(RoomKtorDataSource.ADD_ROOM)
                setBody(roomRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.bodyAsText()
            throw Exception(error)
        }
        return response.bodyAsText()
    }

    override suspend fun fetchRooms(tokenDTO: TokenDTO): RoomResponse<Room> {
        delay(10000)
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(RoomKtorDataSource.FETCH_ROOMS)
                setBody(tokenDTO)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.bodyAsText()
            throw Exception(error)
        }
        println(response.bodyAsText() + "  @@#@#@#")
        return response.body()
    }

    override suspend fun fetchPhotos(tokenDTO: TokenDTO): RoomResponse<String> {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(RoomKtorDataSource.FETCH_PHOTOS)
                setBody(tokenDTO)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.bodyAsText()
            throw Exception(error)
        }
        return response.body()
    }
}