package login

import AuthRepository
import io.github.alexgladkov.kviewmodel.BaseSharedViewModel

import di.Inject
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel: BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState()
) {

    private val authRepository:AuthRepository = Inject.di.get()

    init {
        viewModelScope.launch {
            val token = authRepository.fetchToken()
            if(token != null){
                viewAction = LoginAction.OpenMainFlow
            }
        }

    }

    override fun obtainEvent(viewEvent: LoginEvent) {
        when(viewEvent){

            is LoginEvent.EmailChanged -> {
                obtainEmailChanged(viewEvent.value)
            }

            is LoginEvent.PasswordChanged -> {
                obtainPasswordChanged(viewEvent.value)
            }

            is LoginEvent.RegistrationClick -> {
                openRegistrationScreen()
            }

            is LoginEvent.PasswordHidden -> {
                switchPasswordHidden()
            }

            is LoginEvent.LoginClick -> {
                sendLogin()
            }

        }
    }

    private fun sendLogin() {

        viewState = viewState.copy(
            isSending = true
        )

        viewModelScope.launch {

            try {

                val result = authRepository.performLogin(
                    login = viewState.login,
                    password = viewState.password
                )
                println(result)

                viewAction = LoginAction.OpenMainFlow

            }catch (e:Exception){
                viewState = viewState.copy(error = e.message ?: "", isSending = false)
                println(e.message)
            }

        }
    }

    private fun switchPasswordHidden() {
        viewState = viewState.copy(
            passwordHidden = viewState.passwordHidden.not()
        )
    }

    private fun openRegistrationScreen() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun obtainPasswordChanged(password:String) {
        viewState = viewState.copy(
            password = password
        )
    }

    private fun obtainEmailChanged(email:String){
        viewState = viewState.copy(
            login = email
        )
    }

}