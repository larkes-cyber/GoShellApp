import models.TokenDTO

interface AuthRepository {

    suspend fun performLogin(login:String, password:String):TokenDTO
    suspend fun performRegistration(login:String, password:String, name:String)
    suspend fun fetchToken():TokenDTO?

}