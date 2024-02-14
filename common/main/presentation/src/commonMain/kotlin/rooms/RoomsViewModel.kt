package rooms

import DeviceRepository
import RoomRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import rooms.models.RoomAction
import rooms.models.RoomEvent
import rooms.models.RoomViewState
import rooms.models.RoomWithDevices

class RoomsViewModel:BaseSharedViewModel<RoomViewState, RoomAction, RoomEvent>(
    initialState = RoomViewState()
) {

    private val roomRepository = Inject.di.get<RoomRepository>()
    private val deviceRepository = Inject.di.get<DeviceRepository>()

    init {
        fetchRooms()
    }

    override fun obtainEvent(viewEvent: RoomEvent) {
        when(viewEvent){

            RoomEvent.RoomClick -> {
                openRoomDetailScreen()
            }

        }
    }

    private fun openRoomDetailScreen() {
        viewAction = RoomAction.OpenRoomDetail
    }

    private fun fetchRooms(){
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            try {
                val rooms = roomRepository
                    .fetchRooms()
                    .map { room ->
                        val devices = deviceRepository
                            .fetchRoomDevices(room.id!!)
                            .map { it.icon ?: "" }
                        RoomWithDevices(
                            devices = devices,
                            image = room.image,
                            name = room.name
                        )
                    }
                viewState = viewState.copy(rooms = rooms)

            }catch (e:Exception){

            }
            finally {
                viewState = viewState.copy(isLoading = false)
            }
        }
    }
}