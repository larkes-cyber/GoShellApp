package modal.add_room

import DeviceRepository
import RoomRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import modal.add_room.models.AddRoomAction
import modal.add_room.models.AddRoomEvent
import modal.add_room.models.AddRoomViewState
import models.Device

class AddRoomViewModel: BaseSharedViewModel<AddRoomViewState, AddRoomAction, AddRoomEvent>(
    initialState = AddRoomViewState()
) {

    init {
        viewAction = AddRoomAction.OpenRoomName
    }

    private val roomRepository = Inject.di.get<RoomRepository>()
    private val deviceRepository = Inject.di.get<DeviceRepository>()

    override fun obtainEvent(viewEvent: AddRoomEvent) {
        when(viewEvent){

            is AddRoomEvent.NameChanged -> {
                obtainName(viewEvent.value)
            }

            is AddRoomEvent.DeviceSelected -> {
                obtainDevice(viewEvent.value)
            }

            is AddRoomEvent.ImageSelected -> {
                obtainImage(viewEvent.value)
            }

            is AddRoomEvent.ContinueClicked ->{
                obtainNextPhase()
            }

        }
    }

    private fun obtainNextPhase() {
        when(viewAction){

            AddRoomAction.OpenRoomName -> {
                viewModelScope.launch {
                    try {
                        val images = roomRepository.fetchRoomPhotos()
                        viewState = viewState.copy(fetchedImages = images)
                        viewAction = AddRoomAction.OpenSelectImage
                    }catch (e:Exception){
                        println(e)
                    }
                }
            }

            AddRoomAction.OpenSelectImage -> {
                viewModelScope.launch {
                    try {
                        val devices = deviceRepository.fetchDevices()
                        viewState = viewState.copy(
                            fetchedDevices = devices
                        )
                        viewAction = AddRoomAction.OpenSelectDevices
                    }catch (e:Exception){
                        println(e)
                    }
                }
            }
            AddRoomAction.OpenSelectDevices -> {
                viewAction = AddRoomAction.OpenDone
            }

            AddRoomAction.OpenDone -> {
                viewAction = AddRoomAction.OpenRoomScreen
            }

            else -> {}
        }
    }

    private fun obtainImage(image:String) {
        viewState = viewState.copy(selectedImage = image)
    }

    private fun obtainDevice(device: Device) {

        val devices = viewState.selectedDevices.toMutableList()
        devices.add(device)
        viewState = viewState.copy(selectedDevices = devices)

    }

    private fun obtainName(name:String) {
        viewState = viewState.copy(name = name)
    }
}