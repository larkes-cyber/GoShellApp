import models.TokenDTO

interface AuthRepository {

    suspend fun performLogin(login:String, password:String):TokenDTO
    suspend fun performRegistration(login:String, password:String, name:String): TokenDTO
    suspend fun fetchToken():TokenDTO?
    suspend fun refreshToken()

}