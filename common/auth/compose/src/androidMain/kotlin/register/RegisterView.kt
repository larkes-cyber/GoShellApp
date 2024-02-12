package register

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import login.models.LoginEvent

import registration.models.RegisterEvent
import registration.models.RegisterViewState

@Composable
fun RegisterView(state: RegisterViewState, eventHandler: (RegisterEvent) -> Unit) {
    Column {

        TextField(
            value = state.name,
            onValueChange = {
                eventHandler(RegisterEvent.NameChanged(it))
            }
        )

        TextField(
            value = state.login,
            onValueChange = {
                eventHandler(RegisterEvent.EmailChanged(it))
            }
        )

        TextField(
            value = state.password,
            onValueChange = {
                eventHandler(RegisterEvent.PasswordChanged(it))
            }
        )

        Button(
            onClick = {
                eventHandler(RegisterEvent.RegisterClick)
            }
        ){
            Text("Click")
        }

        Button(
            onClick = {
                eventHandler(RegisterEvent.LoginClick)
            }
        ){
            Text("to login")
        }

    }
}