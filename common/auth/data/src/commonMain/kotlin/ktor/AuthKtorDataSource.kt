package ktor

import models.LoginRequest
import models.RegistrationRequest
import models.TokenDTO

interface AuthKtorDataSource {

    suspend fun sendLogin(loginRequest: LoginRequest): TokenDTO
    suspend fun sendRegistration(registrationRequest: RegistrationRequest)

    companion object{

        const val LOGIN_GO_SHELL = "auth/login"
        const val REGISTRATION_GO_SHELL = "auth/registration"

    }

}