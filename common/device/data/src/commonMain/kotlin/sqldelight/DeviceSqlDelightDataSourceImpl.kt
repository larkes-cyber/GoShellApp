package sqldelight

import com.larkes.goshellapp.RoomDatabase
import models.RoomDevice

class DeviceSqlDelightDataSourceImpl(
    private val db:RoomDatabase
):DeviceSqlDelightDataSource {

    private val queries = db.roomDeviceEntityQueries

    override suspend fun cacheRoomDevice(roomDevice: RoomDevice) {
        queries.insertRoomDevice(
            id = roomDevice.id!!,
            active = roomDevice.active,
            icon = roomDevice.icon,
            name = roomDevice.name,
            roomId = roomDevice.roomId,
            typeId = roomDevice.typeId
        )
    }

    override suspend fun fetchRoomDevices(): List<RoomDevice> {
        return queries.fetchRoomDevices().executeAsList().map {roomDevice ->
            RoomDevice(
                id = roomDevice.id,
                active = roomDevice.active,
                icon = roomDevice.icon,
                name = roomDevice.name,
                roomId = roomDevice.roomId,
                typeId = roomDevice.typeId
            )
        }
    }

    override suspend fun clearRoomDevices() {
        queries.removeRoomDevices()
    }
}