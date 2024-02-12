package settings

import models.TokenDTO


interface AuthSettingDataSource {

    suspend fun putToken(token: TokenDTO)
    suspend fun fetchToken():TokenDTO?

}