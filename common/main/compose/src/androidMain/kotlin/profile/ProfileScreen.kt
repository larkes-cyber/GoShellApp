package profile

import androidx.compose.runtime.Composable
import io.github.alexgladkov.kviewmodel.compose.observeAsState
import io.github.alexgladkov.kviewmodel.odyssey.StoredViewModel

@Composable
fun ProfileScreen() {

    StoredViewModel(factory = { ProfileViewModel() }){ viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()
        ProfileView(viewState = state.value){event ->
            viewModel.obtainEvent(event)
        }
    }

}