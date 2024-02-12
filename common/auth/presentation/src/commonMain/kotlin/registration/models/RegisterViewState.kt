package registration.models

data class RegisterViewState(
    val name:String = "",
    val login:String = "",
    val password:String = "",
    val isSending:Boolean = false,
    val passwordHidden:Boolean = false
)