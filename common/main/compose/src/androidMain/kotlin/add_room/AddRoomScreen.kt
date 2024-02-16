package add_room

import add_room.models.AddRoomAction
import add_room.views.DoneView
import add_room.views.RoomNameView
import add_room.views.SelectDevicesView
import add_room.views.SelectImageView
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun AddRoomScreen(onCloseClick: () -> Unit) {

    val rootController = LocalRootController.current

    StoredViewModel(factory = { AddRoomViewModel() }){ viewModel ->
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