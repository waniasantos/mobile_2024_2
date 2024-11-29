package com.example.animalapp

import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimalScreen(animal: String) {
    val context = LocalContext.current

    val imageRes = when (animal) {
        stringResource(R.string.menu_doguinha) -> R.drawable.claudia
        stringResource(R.string.menu_catinha) -> R.drawable.panda
        else -> {
            Log.e("AnimalApp", "Animal não reconhecido: $animal")
            R.drawable.default_image
        }
    }
    val soundRes = when (animal) {
        stringResource(R.string.menu_doguinha) -> R.raw.claudia_audio
        stringResource(R.string.menu_catinha) -> R.raw.panda_audio
        else -> null
    }
    val videoRes = when (animal) {
        stringResource(R.string.menu_doguinha) -> R.raw.claudia_video
        stringResource(R.string.menu_catinha) -> R.raw.panda_video
        else -> null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "$animal Image",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = animal,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.black)
        )
        Spacer(modifier = Modifier.height(16.dp))

        soundRes?.let {
            Button(
                onClick = {
                    try {
                        val mediaPlayer = MediaPlayer.create(context, it)
                        mediaPlayer?.start()
                        mediaPlayer?.setOnCompletionListener { player -> player.release() }
                    } catch (e: Exception) {
                        Log.e("AnimalApp", "Erro ao reproduzir som: ${e.message}")
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue_paws),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(stringResource(R.string.button_play_sound))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        videoRes?.let {
            Button(
                onClick = {
                    val intent = Intent(context, VideoPlayerActivity::class.java)
                    intent.putExtra("videoRes", it)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue_paws),
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(stringResource(R.string.button_play_video))
            }
        }
    }
}
