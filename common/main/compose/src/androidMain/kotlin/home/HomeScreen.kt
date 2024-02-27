package home

import androidx.compose.runtime.Composable
import io.github.alexgladkov.kviewmodel.compose.observeAsState
import io.github.alexgladkov.kviewmodel.odyssey.StoredViewModel
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