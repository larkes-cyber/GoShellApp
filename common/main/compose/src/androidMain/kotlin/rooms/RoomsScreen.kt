package rooms


import add_room.AddRoomScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import home.HomeView
import home.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import navigation.NavigationTree
import rooms.models.RoomAction
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.compose.navigation.modal_navigation.ModalSheetConfiguration

@OptIn(ExperimentalMaterialApi::class)
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
                    AddRoomScreen(){
                        modalController.popBackStack(key)

                    }
                }
            }

            else -> {}
        }

    }

}