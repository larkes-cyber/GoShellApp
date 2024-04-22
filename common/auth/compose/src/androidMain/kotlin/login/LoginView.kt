package login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.models.LoginEvent
import login.models.LoginViewState

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {


    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))


        TextField(
            value = state.login,
            onValueChange = {
                eventHandler(LoginEvent.EmailChanged(it))
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Enter your login")
            }
        )

        TextField(
            value = state.password,
            onValueChange = {
                eventHandler(LoginEvent.PasswordChanged(it))
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Enter your password")
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                eventHandler(LoginEvent.LoginClick)
            },
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(12.dp),
            enabled = state.isSending.not()
        ){
            Text("Click")
        }

        Spacer(Modifier.height(7.dp))

        ClickableText(
            text = AnnotatedString("to register")
        ){
            eventHandler(LoginEvent.RegistrationClick)

        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = state.error,
            fontSize = 15.sp,
            color = Color.Red
        )


    }

}