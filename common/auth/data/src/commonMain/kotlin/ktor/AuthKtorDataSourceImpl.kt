package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.readText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.path
import models.LoginRequest
import models.RegistrationRequest
import models.TokenDTO

class AuthKtorDataSourceImpl(
    private val httpClient: HttpClient
):AuthKtorDataSource {

    override suspend fun sendLogin(loginRequest: LoginRequest): TokenDTO {
        val response =  httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(AuthKtorDataSource.LOGIN_GO_SHELL)
                setBody(loginRequest)
            }
        }

        if(response.status.isSuccess().not()){
            val error = response.bodyAsText()
            throw Exception(error)
        }

        return response.body()
    }

    override suspend fun sendRegistration(registrationRequest: RegistrationRequest): TokenDTO {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(AuthKtorDataSource.REGISTRATION_GO_SHELL)
                setBody(registrationRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.bodyAsText()
            throw Exception(error)
        }
        return response.body()
    }
}