package profile

import ProfileRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import profile.models.ProfileAction
import profile.models.ProfileEvent
import profile.models.ProfileViewState

class ProfileViewModel:BaseSharedViewModel<ProfileViewState, ProfileAction, ProfileEvent>(
    initialState = ProfileViewState()
) {

    private val profileRepository = Inject.di.get<ProfileRepository>()

    init {
        fetchProfile()
    }

    override fun obtainEvent(viewEvent: ProfileEvent) {
        when(viewEvent){
            ProfileEvent.EditProfileClick -> {
                openEditScreen()
            }
        }
    }

    private fun openEditScreen() {
        viewAction = ProfileAction.OpenEditProfile
    }

    private fun fetchProfile(){
        viewModelScope.launch {
            viewState = viewState.copy(isLoading = true)
            try {
                viewState =viewState.copy(profile = profileRepository.fetchProfile())
            }catch (e:Exception){
                println(e.toString() + "  @#$@$@#$#@")
            }
            finally {
                viewState =viewState.copy(isLoading = false)
            }
        }
    }
}