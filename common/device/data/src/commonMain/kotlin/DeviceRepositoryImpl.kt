import ktor.DeviceKtorDataSource
import models.AddRoomDeviceRequest
import models.Device
import models.DeviceActiveRequest
import models.GetRoomDevicesRequest
import models.HomeDevices
import models.RoomDevice

class DeviceRepositoryImpl(
    private val authRepository: AuthRepository,
    private val deviceKtorDataSource: DeviceKtorDataSource
):DeviceRepository {
    override suspend fun fetchDevices(): List<Device> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return deviceKtorDataSource.fetchDevices(token)
    }

    override suspend fun fetchRoomDevices(roomId: String): List<RoomDevice> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return deviceKtorDataSource.fetchRoomDevices(GetRoomDevicesRequest(
            roomId = roomId,
            token = token
        ))
    }

    override suspend fun addRoomDevice(roomDevice: RoomDevice) {
        val token = authRepository.fetchToken() ?: return
        deviceKtorDataSource.addRoomDevice(
            AddRoomDeviceRequest(
                roomId = roomDevice.roomId,
                token = token,
                typeId = roomDevice.typeId,
                name = roomDevice.name
            )
        )
    }

    override suspend fun switchDeviceActive(deviceId: String) {
        val token = authRepository.fetchToken() ?: return
        deviceKtorDataSource.switchDeviceActive(
            DeviceActiveRequest(
                id = deviceId,
                token = token
            )
        )
    }

    override suspend fun fetchHomeDevices(): List<HomeDevices> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return deviceKtorDataSource.fetchHomeDevices(token)
    }
}