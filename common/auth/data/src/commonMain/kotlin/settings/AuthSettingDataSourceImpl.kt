package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import kotlinx.serialization.json.Json
import models.TokenDTO

class AuthSettingDataSourceImpl(
    private val settings:Settings
):AuthSettingDataSource {
    override suspend fun putToken(token: TokenDTO) {
        settings.putString(token_key, Json.encodeToString(TokenDTO.serializer(), token))
    }

    override suspend fun fetchToken(): TokenDTO? {
        val token = settings[token_key, ""]
        if(token.isEmpty())return null
        return Json.decodeFromString(TokenDTO.serializer(), token)
    }

    companion object{
        private const val token_key = "Token"
    }

}