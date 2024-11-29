package com.example.animalapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class VideoPlayerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtém o recurso de vídeo enviado pela Activity anterior
        val videoRes = intent.getIntExtra("videoRes", -1)
        if (videoRes == -1) {
            finish() // Finaliza se o recurso não foi recebido
            return
        }

        setContent {
            VideoPlayerScreen(
                videoRes = videoRes,
                onBackToHome = {
                    // Volta para a tela inicial
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish() // Finaliza a VideoPlayerActivity
                }
            )
        }
    }
}
