package ktor

import models.LoginRequest
import models.RegistrationRequest
import token.TokenDTO

interface AuthKtorDataSource {

    suspend fun sendLogin(loginRequest: LoginRequest):TokenDTO
    suspend fun sendRegistration(registrationRequest: RegistrationRequest):TokenDTO

    companion object{

        const val LOGIN_GO_SHELL = "/login"
        const val REGISTRATION_GO_SHELL = "/registration"

    }

}