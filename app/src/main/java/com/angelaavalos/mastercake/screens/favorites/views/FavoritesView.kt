package com.angelaavalos.mastercake.screens.favorites


import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.angelaavalos.mastercake.navigation.components.BottomNavBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun FavoritesView(navController: NavController, videoUris: List<Uri>) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Promos") }) },
        content = {
            Column {
                videoUris.forEach { videoUri ->
                    VideoPlayerView(videoUri)
                }
            }
        },
        bottomBar = { BottomNavBar(navController = navController) }
    )
}


@Composable
fun VideoPlayerView(videoUri: Uri) {
    val context = LocalContext.current

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp),
        factory = {
            VideoView(context).apply {
                setVideoURI(videoUri)

                val mediaController = MediaController(context)
                mediaController.setAnchorView(this)

                setMediaController(mediaController)

                setOnPreparedListener {
                    start()
                }
            }
        }
    )
}


