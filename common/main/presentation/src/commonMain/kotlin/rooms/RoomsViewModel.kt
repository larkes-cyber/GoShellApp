package rooms

import DeviceRepository
import RoomRepository
import io.github.alexgladkov.kviewmodel.BaseSharedViewModel
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
        fetchRooms(4)
    }

    override fun obtainEvent(viewEvent: RoomEvent) {
        when(viewEvent){

            RoomEvent.RoomClick -> {
                openRoomDetailScreen()
            }

            RoomEvent.AddRoomClick -> {
                fetchRooms(4)
            }

            RoomEvent.CloseAddRoomModal -> {
                closeAddRoom()
            }

            RoomEvent.AddRoomModalClick -> {
                openAddRoom()
            }
            RoomEvent.Refresh -> {
                fetchRooms(  4)
            }
            RoomEvent.NewRooms -> {
                fetchRooms(viewState.rooms.size + 4, false)
            }

        }
    }

    private fun closeAddRoom(){
        viewAction = RoomAction.OpenRooms
    }

    private fun openAddRoom() {
        viewAction = RoomAction.OpenAddRoom
    }

    private fun openRoomDetailScreen() {
        viewAction = RoomAction.OpenRoomDetail
    }

    private fun fetchRooms(count:Int, loadingEffect:Boolean = true){
        viewModelScope.launch {
           if(loadingEffect) viewState = viewState.copy(isLoading = true, rooms = emptyList())
            try {
                val rooms = roomRepository
                    .fetchRooms(
                        count = count
                    )
                    .map { room ->
                        val devices = deviceRepository
                            .fetchRoomDevices(room.id!!)
                            .map { it.icon ?: "" }
                        println(devices.toString() + " BCVBVVVVV")
                        RoomWithDevices(
                            devices = devices,
                            image = room.image,
                            name = room.name
                        )
                    }

                viewState = viewState.copy(paginingHidden = rooms.size == viewState.rooms.size, rooms = rooms)
            }catch (e:Exception){
                println(e.toString() + "   #$%#$#$#")
            }
            finally {
                viewState = viewState.copy(isLoading = false)
            }
        }
    }
}