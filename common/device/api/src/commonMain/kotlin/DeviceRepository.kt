import models.Device
import models.HomeDevices
import models.RoomDevice

interface DeviceRepository {
    suspend fun fetchDevices():List<Device>
    suspend fun fetchRoomDevices(roomId:String):List<RoomDevice>
    suspend fun addRoomDevice(roomDevice: RoomDevice)
    suspend fun switchDeviceActive(deviceId:String)
    suspend fun fetchHomeDevices():List<HomeDevices>
}