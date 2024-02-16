package home

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun HomeScreen() {

    val rootController = LocalRootController.current

    StoredViewModel(factory = { HomeViewModel() }){ viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        HomeView(state.value){
            viewModel.obtainEvent(it)
        }
    }

}