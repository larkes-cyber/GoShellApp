package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.path
import models.Profile
import models.ProfileRequest
import models.TokenDTO

class ProfileKtorDataSourceImpl(
    private val httpClient: HttpClient
):ProfileKtorDataSource {
    override suspend fun fetchProfile(token: TokenDTO): Profile {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(ProfileKtorDataSource.FETCH_PROFILE)
                setBody(token)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.bodyAsText()
            throw Exception(error)
        }
        return response.body()
    }

    override suspend fun editProfile(profileRequest: ProfileRequest) {
        val response = httpClient.post{
            contentType(ContentType.Application.Json)
            url {
                path(ProfileKtorDataSource.EDIT_PROFILE)
                setBody(profileRequest)
            }
        }
        if(response.status.isSuccess().not()){
            val error = response.bodyAsText()
            throw Exception(error)
        }
    }
}