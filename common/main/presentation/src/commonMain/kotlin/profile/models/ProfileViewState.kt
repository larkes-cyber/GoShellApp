package profile.models

import models.Profile

data class ProfileViewState(
    val profile:Profile? = null,
    val isLoading:Boolean = false
)