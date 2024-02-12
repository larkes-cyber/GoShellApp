package registration.models

sealed class RegisterAction {
    data object OpenLoginScreen: RegisterAction()
    data object OpenMainFlow: RegisterAction()
}