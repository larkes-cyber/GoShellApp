package modal.add_room

import androidx.compose.runtime.Composable
import io.github.alexgladkov.kviewmodel.compose.ViewModel
import io.github.alexgladkov.kviewmodel.compose.observeAsState
import io.github.alexgladkov.kviewmodel.odyssey.StoredViewModel
import modal.add_room.models.AddRoomAction
import modal.add_room.models.AddRoomEvent
import modal.add_room.view.DoneView
import modal.add_room.view.RoomNameView
import modal.add_room.view.SelectDevicesView
import modal.add_room.view.SelectImageView
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun AddRoomModal(onCloseClick:() -> Unit) {

    ViewModel(factory = { AddRoomViewModel() }){ viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()


        when(action.value){

            is AddRoomAction.OpenRoomName -> {
                RoomNameView(viewState = state.value){
                    viewModel.obtainEvent(it)
                }
            }

            is AddRoomAction.OpenSelectImage -> {
                SelectImageView(viewState = state.value){
                    viewModel.obtainEvent(it)
                }
            }

            is AddRoomAction.OpenSelectDevices -> {
                SelectDevicesView(viewState = state.value){
                    viewModel.obtainEvent(it)
                }
            }

            is AddRoomAction.OpenDone -> {
                DoneView(){
                    viewModel.obtainEvent(it)
                }
            }

            is AddRoomAction.OpenRoomScreen -> {
                onCloseClick()
            }

            else -> {}
        }

    }
}