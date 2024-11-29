package com.example.animalapp

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoPlayerScreen(videoRes: Int, onBackToHome: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Adiciona o VideoView
            AndroidView(
                factory = { context ->
                    val videoView = VideoView(context)

                    // Configura os controles de mídia
                    val mediaController = MediaController(context)
                    mediaController.setAnchorView(videoView)
                    videoView.setMediaController(mediaController)

                    // Configura o vídeo
                    val videoUri = Uri.parse("android.resource://${context.packageName}/$videoRes")
                    videoView.setVideoURI(videoUri)
                    videoView.start()

                    videoView
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )

            // Botão para voltar à tela inicial
            Button(
                onClick = onBackToHome,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue_paws),
                    contentColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(0.8f)
                    .height(60.dp)
            ) {
                Text(
                    text = stringResource(R.string.button_back_to_home),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
