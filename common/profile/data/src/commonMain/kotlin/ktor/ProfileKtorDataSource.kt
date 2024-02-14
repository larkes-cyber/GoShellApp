package ktor

import models.Profile
import models.ProfileRequest
import models.TokenDTO

interface ProfileKtorDataSource {
    suspend fun fetchProfile(token:TokenDTO):Profile
    suspend fun editProfile(profileRequest: ProfileRequest)

    companion object{

        const val FETCH_PROFILE = "profile/get"
        const val EDIT_PROFILE = "profile/edit"

    }

}