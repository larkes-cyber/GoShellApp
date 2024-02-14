import models.Profile
import models.TokenDTO

interface ProfileRepository {
    suspend fun fetchProfile():Profile?
    suspend fun editProfile(profile:Profile)
}