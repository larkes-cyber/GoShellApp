package profile.models

sealed class ProfileAction {

    data object OpenEditProfile:ProfileAction()

}