package login.models

sealed class LoginEvent {

    data class EmailChanged(val value:String):LoginEvent()
    data class PasswordChanged(val value:String):LoginEvent()
    data object PasswordHidden:LoginEvent()
    data object RegistrationClick:LoginEvent()
    data object LoginClick:LoginEvent()

}