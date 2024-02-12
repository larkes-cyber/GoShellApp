package login

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import login.models.LoginEvent
import login.models.LoginViewState

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {

    Column {

        TextField(
            value = state.login,
            onValueChange = {
                eventHandler(LoginEvent.EmailChanged(it))
            }
        )

        TextField(
            value = state.password,
            onValueChange = {
                eventHandler(LoginEvent.PasswordChanged(it))
            }
        )

        Button(
            onClick = {
                eventHandler(LoginEvent.LoginClick)
            }
        ){
            Text("Click")
        }

        Button(
            onClick = {
                eventHandler(LoginEvent.RegistrationClick)
            }
        ){
            Text("to register")
        }

    }

}