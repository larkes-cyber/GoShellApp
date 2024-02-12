package registration.models

sealed class RegisterEvent {
    data class NameChanged(val value:String): RegisterEvent()
    data class EmailChanged(val value:String): RegisterEvent()
    data class PasswordChanged(val value:String): RegisterEvent()
    data object PasswordHidden: RegisterEvent()
    data object LoginClick: RegisterEvent()
    data object RegisterClick: RegisterEvent()
}