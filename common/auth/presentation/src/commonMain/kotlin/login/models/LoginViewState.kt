package login.models

data class LoginViewState(
    val login:String = "",
    val password:String = "",
    val isSending:Boolean = false,
    val passwordHidden:Boolean = false,
    val error:String = ""
)