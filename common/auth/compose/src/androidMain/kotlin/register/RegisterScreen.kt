package register

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.LoginView
import login.LoginViewModel
import login.models.LoginAction
import navigation.NavigationTree
import registration.RegisterViewModel
import registration.models.RegisterAction
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun RegisterScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { RegisterViewModel() }){ viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val action = viewModel.viewActions().observeAsState()

        RegisterView(state.value){
            viewModel.obtainEvent(it)
        }

        when(action.value){
            is RegisterAction.OpenLoginScreen -> {
                rootController.push(NavigationTree.Auth.Login.name)
            }

            is RegisterAction.OpenMainFlow -> {
//                rootController.findRootController()
//                    .present(
//                        screen = NavigationTree.Main.Dashboard.name,
//                        launchFlag = LaunchFlag.SingleNewTask
//                    )
            }

            else -> {}
        }

    }
}