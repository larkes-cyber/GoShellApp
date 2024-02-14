package rooms

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import home.HomeView
import home.HomeViewModel
import navigation.NavigationTree
import rooms.models.RoomAction
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun RoomsScreen() {

    val rootController = LocalRootController.current

    StoredViewModel(factory = { RoomsViewModel() }){ viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        RoomsView(state.value){
            viewModel.obtainEvent(it)
        }

        when(action.value){
            is RoomAction.OpenRoomDetail -> {
                rootController.push(NavigationTree.Main.RoomDetail.name)
            }
            else -> {}
        }

    }

}