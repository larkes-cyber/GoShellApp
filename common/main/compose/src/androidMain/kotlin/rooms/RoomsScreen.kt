package rooms

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import io.github.alexgladkov.kviewmodel.compose.observeAsState
import io.github.alexgladkov.kviewmodel.odyssey.StoredViewModel
import modal.add_room.AddRoomModal
import rooms.models.RoomAction
import rooms.models.RoomEvent
import ru.alexgladkov.odyssey.compose.extensions.observeAsState
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalSheetConfiguration

@Composable
fun RoomsScreen() {

    val rootController = LocalRootController.current
    val modalController = rootController.findModalController()
    val modalSheetConfiguration = ModalSheetConfiguration(cornerRadius = 16, closeOnSwipe = true)



    StoredViewModel(factory = { RoomsViewModel() }){ viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()




        RoomsView(state.value){
            viewModel.obtainEvent(it)
        }
        println(action.value)
        when(action.value){
            is RoomAction.OpenAddRoom -> {

                modalController.present(modalSheetConfiguration){key ->
                    AddRoomModal{
                        viewModel.obtainEvent(RoomEvent.AddRoomClick)
                        modalController.popBackStack(key)
                    }
                    viewModel.obtainEvent(RoomEvent.CloseAddRoomModal)
                }

            }

            else -> {}
        }

    }

}