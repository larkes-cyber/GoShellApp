package sqldelight

import models.RoomDevice

interface DeviceSqlDelightDataSource {
    suspend fun cacheRoomDevice(roomDevice: RoomDevice)
    suspend fun fetchRoomDevices():List<RoomDevice>
    suspend fun clearRoomDevices()
}