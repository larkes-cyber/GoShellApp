package rooms

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import modal.add_room.AddRoomModal
import rooms.models.RoomAction
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalSheetConfiguration

@Composable
fun RoomsScreen() {

    val rootController = LocalRootController.current
    val modalController = rootController.findModalController()
    val modalSheetConfiguration = ModalSheetConfiguration(cornerRadius = 16)




    StoredViewModel(factory = { RoomsViewModel() }){ viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()




        RoomsView(state.value){
            viewModel.obtainEvent(it)
        }

        when(action.value){
            is RoomAction.OpenAddRoom -> {
                modalController.present(modalSheetConfiguration){key ->
                    AddRoomModal{
                        modalController.popBackStack(key)

                    }
                }
            }

            else -> {}
        }

    }

}