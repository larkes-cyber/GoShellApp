package settings

import token.TokenDTO

interface AuthSettingDataSource {

    suspend fun putToken(token:TokenDTO)
    suspend fun fetchToken():TokenDTO?

}