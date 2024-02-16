package add_room.views

import add_room.models.AddRoomEvent
import add_room.models.AddRoomViewState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage

@Composable
fun SelectImageView(viewState: AddRoomViewState, viewEvent:(AddRoomEvent) -> Unit) {

    val rememberScrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 15.dp).verticalScroll(rememberScrollState)
    ) {

        viewState.fetchedImages.forEach {
            SubcomposeAsyncImage(
                modifier = Modifier.clip(RoundedCornerShape(28.dp)).fillMaxWidth().height(160.dp),
                model = it,
                contentScale = ContentScale.FillBounds,
                contentDescription = "Avatar",
                loading = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Box(modifier = Modifier.size(25.dp)) {
                            CircularProgressIndicator()
                        }
                    }

                }
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
        Button(
            onClick = {
                viewEvent(AddRoomEvent.ContinueClicked)
            }
        ){
            Text("Continue")
        }
    }

}