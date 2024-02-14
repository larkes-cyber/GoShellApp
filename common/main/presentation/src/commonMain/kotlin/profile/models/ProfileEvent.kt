package profile.models

sealed class ProfileEvent {

    data object EditProfileClick:ProfileEvent()

}