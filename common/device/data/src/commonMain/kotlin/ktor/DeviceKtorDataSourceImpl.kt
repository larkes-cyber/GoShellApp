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
import models.AddRoomDeviceRequest
import models.Device
import models.DeviceActiveRequest
import models.DeviceResponse
import models.GetRoomDevicesRequest
import models.HomeDevices
import models.RoomDevice
import models.TokenDTO

class DeviceKtorDataSourceImpl(
    private val httpClient: HttpClient
):DeviceKtorDataSource {
    override suspend fun fetchDevices(tokenDTO: TokenDTO): List<Device> {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(DeviceKtorDataSource.FETCH_DEVICES)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
        return response.body()
    }

    override suspend fun fetchRoomDevices(tokenDTO: TokenDTO, getRoomDevicesRequest: GetRoomDevicesRequest): List<RoomDevice> {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(DeviceKtorDataSource.FETCH_ROOM_DEVICES)
                setBody(getRoomDevicesRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
        return response.body()
    }

    override suspend fun addRoomDevice(tokenDTO: TokenDTO, addRoomDeviceRequest: AddRoomDeviceRequest):String {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(DeviceKtorDataSource.ADD_ROOM_DEVICE)
                setBody(addRoomDeviceRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
        return response.bodyAsText()
    }

    override suspend fun switchDeviceActive(tokenDTO: TokenDTO, deviceActiveRequest: DeviceActiveRequest) {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(DeviceKtorDataSource.SWITCH_DEVICE_ACTIVE)
                setBody(deviceActiveRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
    }

    override suspend fun fetchHomeDevices(tokenDTO: TokenDTO): DeviceResponse<HomeDevices> {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(DeviceKtorDataSource.FETCH_HOME_DEVICES)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
        return response.body()
    }

    override suspend fun switchDevicesActive(tokenDTO: TokenDTO, deviceActiveRequest: DeviceActiveRequest) {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                header("Authorization", "Bearer ${tokenDTO.token}")
                path(DeviceKtorDataSource.SWITCH_DEVICES_ACTIVE)
                setBody(deviceActiveRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.status.description
            throw Exception(error)
        }
    }
}