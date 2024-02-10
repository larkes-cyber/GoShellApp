package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.path
import models.LoginRequest
import models.RegistrationRequest
import token.TokenDTO

class AuthKtorDataSourceImpl(
    private val httpClient: HttpClient
):AuthKtorDataSource {

    override suspend fun sendLogin(loginRequest: LoginRequest): TokenDTO {
        return httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(AuthKtorDataSource.LOGIN_GO_SHELL)
                setBody(loginRequest)
            }
        }.body()
    }

    override suspend fun sendRegistration(registrationRequest: RegistrationRequest): TokenDTO {
        return httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(AuthKtorDataSource.REGISTRATION_GO_SHELL)
                setBody(registrationRequest)
            }
        }.body()
    }
}