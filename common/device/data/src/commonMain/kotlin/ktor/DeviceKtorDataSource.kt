package ktor

import models.AddRoomDeviceRequest
import models.Device
import models.DeviceActiveRequest
import models.DeviceResponse
import models.GetRoomDevicesRequest
import models.HomeDevices
import models.RoomDevice
import models.TokenDTO

interface DeviceKtorDataSource {
    suspend fun fetchDevices(tokenDTO: TokenDTO):List<Device>
    suspend fun fetchRoomDevices(getRoomDevicesRequest: GetRoomDevicesRequest):List<RoomDevice>
    suspend fun addRoomDevice(addRoomDeviceRequest: AddRoomDeviceRequest)
    suspend fun switchDeviceActive(deviceActiveRequest: DeviceActiveRequest)
    suspend fun fetchHomeDevices(tokenDTO: TokenDTO): DeviceResponse<HomeDevices>
    suspend fun switchDevicesActive(deviceActiveRequest: DeviceActiveRequest)

    companion object{

        const val FETCH_DEVICES = "device/get"
        const val FETCH_ROOM_DEVICES = "device/getRoom"
        const val ADD_ROOM_DEVICE = "device/addRoom"
        const val SWITCH_DEVICE_ACTIVE = "device/switchActive"
        const val FETCH_HOME_DEVICES = "device/getHome"
        const val SWITCH_DEVICES_ACTIVE = "device/switchDevicesActive"

    }

}