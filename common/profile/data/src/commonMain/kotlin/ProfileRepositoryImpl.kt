import ktor.ProfileKtorDataSource
import models.Profile
import models.ProfileRequest

class ProfileRepositoryImpl(
    private val profileKtorDataSource: ProfileKtorDataSource,
    private val authRepository: AuthRepository
):ProfileRepository {
    override suspend fun fetchProfile(): Profile? {
        val token = authRepository.fetchToken() ?: return null
        return profileKtorDataSource.fetchProfile(token)
    }

    override suspend fun editProfile(profile: Profile) {
        val token = authRepository.fetchToken() ?: return
        profileKtorDataSource.editProfile(ProfileRequest(
            token = token,
            profile = profile
        ))
    }
}