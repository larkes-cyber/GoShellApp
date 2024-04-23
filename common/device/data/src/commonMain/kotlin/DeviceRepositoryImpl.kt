import ktor.DeviceKtorDataSource
import models.AddRoomDeviceRequest
import models.Device
import models.DeviceActiveRequest
import models.GetRoomDevicesRequest
import models.HomeDevices
import models.RoomDevice
import sqldelight.DeviceSqlDelightDataSource

class DeviceRepositoryImpl(
    private val authRepository: AuthRepository,
    private val deviceKtorDataSource: DeviceKtorDataSource,
    private val deviceSqlDelightDataSource: DeviceSqlDelightDataSource
):DeviceRepository {
    override suspend fun fetchDevices(): List<Device> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return deviceKtorDataSource.fetchDevices(token)
    }

    override suspend fun fetchRoomDevices(roomId: String): List<RoomDevice> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return try {
                val devices = deviceKtorDataSource.fetchRoomDevices(token, GetRoomDevicesRequest(roomId = roomId))
                devices.forEach {
                    deviceSqlDelightDataSource.cacheRoomDevice(it)
                }
                devices
            } catch (e:Exception){
            deviceSqlDelightDataSource.fetchRoomDevices()
        }
    }

    override suspend fun addRoomDevice(roomDevice: RoomDevice) {
        val token = authRepository.fetchToken() ?: return
        val id = deviceKtorDataSource.addRoomDevice(token,
            AddRoomDeviceRequest(
                roomId = roomDevice.roomId,
                typeId = roomDevice.typeId,
                name = roomDevice.name
            )
        )
        roomDevice.id = id
        deviceSqlDelightDataSource.cacheRoomDevice(roomDevice)

    }

    override suspend fun switchDeviceActive(deviceId: String) {
        val token = authRepository.fetchToken() ?: return
        deviceKtorDataSource.switchDeviceActive(token,
            DeviceActiveRequest(
                id = deviceId
            )
        )
    }

    override suspend fun fetchHomeDevices(): List<HomeDevices> {
        val token = authRepository.fetchToken() ?: return emptyList()
        return deviceKtorDataSource.fetchHomeDevices(token).devices
    }

    override suspend fun switchDevicesActive(typeId: String) {
        val token = authRepository.fetchToken() ?: return
        deviceKtorDataSource.switchDevicesActive(token, DeviceActiveRequest(
            id = typeId
        ))
    }
}