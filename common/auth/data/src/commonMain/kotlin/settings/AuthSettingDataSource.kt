package settings

import models.TokenDTO
import models.UserData


interface AuthSettingDataSource {

    suspend fun putToken(token: TokenDTO)
    suspend fun fetchToken():TokenDTO?
    suspend fun putUserData(userData: UserData)
    suspend fun fetchUserData():UserData?

}