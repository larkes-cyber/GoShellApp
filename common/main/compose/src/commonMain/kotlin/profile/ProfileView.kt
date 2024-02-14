package profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import profile.models.ProfileEvent
import profile.models.ProfileViewState

@Composable
fun ProfileView(viewState: ProfileViewState, viewEvent: (ProfileEvent) -> Unit) {
    Text("Profile: $viewState")
}