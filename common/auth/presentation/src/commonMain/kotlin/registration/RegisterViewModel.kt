package registration

import AuthRepository
import io.github.alexgladkov.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import registration.models.RegisterAction
import registration.models.RegisterEvent
import registration.models.RegisterViewState

class RegisterViewModel:BaseSharedViewModel<RegisterViewState, RegisterAction, RegisterEvent>(
    initialState = RegisterViewState()
) {

    private val authRepository:AuthRepository = Inject.di.get()

    override fun obtainEvent(viewEvent: RegisterEvent) {
        when(viewEvent){
            is RegisterEvent.NameChanged -> {
                obtainNameChanged(viewEvent.value)

            }
            is RegisterEvent.EmailChanged -> {
                obtainEmailChanged(viewEvent.value)
            }

            is RegisterEvent.PasswordChanged -> {
                obtainPasswordChanged(viewEvent.value)
            }

            is RegisterEvent.RegisterClick -> {
                sendRegister()
            }

            is RegisterEvent.PasswordHidden -> {
                switchPasswordHidden()
            }

            is RegisterEvent.LoginClick -> {
                openLoginScreen()
            }

        }
    }

    private fun openLoginScreen() {
        viewAction = RegisterAction.OpenLoginScreen
    }

    private fun sendRegister() {
        viewState = viewState.copy(
            isSending = true
        )

        viewModelScope.launch {

            try {

                val result = authRepository.performRegistration(
                    login = viewState.login,
                    password = viewState.password,
                    name = viewState.name
                )
                println(result)

                viewAction = RegisterAction.OpenMainFlow

            }catch (e:Exception){
                println(e.message)
            }

        }
    }

    private fun switchPasswordHidden() {
        viewState = viewState.copy(passwordHidden = viewState.passwordHidden.not())
    }


    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(
            password = value
        )
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(
            login = value
        )
    }

    private fun obtainNameChanged(value: String) {
        viewState = viewState.copy(
            name = value
        )
    }
}