import ktor.AuthKtorDataSource
import models.LoginRequest
import models.RegistrationRequest
import models.TokenDTO
import models.UserData
import settings.AuthSettingDataSource

class AuthRepositoryImpl(
    private val authKtorDataSource: AuthKtorDataSource,
    private val authSettingDataSource: AuthSettingDataSource
):AuthRepository {
    override suspend fun performLogin(login: String, password: String): TokenDTO {
        val token = authKtorDataSource.sendLogin(LoginRequest(
            login = login,
            password = password
        ))
        authSettingDataSource.putToken(token)

        return token
    }

    override suspend fun performRegistration(login: String, password: String, name: String) {
        authKtorDataSource.sendRegistration(RegistrationRequest(
            login = login,
            password = password,
            name = name
        ))
    }

    override suspend fun fetchToken(): TokenDTO? {
        return authSettingDataSource.fetchToken()
    }

}