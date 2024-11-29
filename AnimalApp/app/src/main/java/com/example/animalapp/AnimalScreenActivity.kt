package com.example.animalapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.animalapp.ui.theme.AnimalAppTheme

class AnimalScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animal = intent.getStringExtra("animal")
        if (animal == null) {
            Log.e("AnimalApp", "Animal não recebido!")
            finish()
            return
        }

        setContent {
            AnimalAppTheme {
                AnimalScreen(animal) // Usa a função importada do arquivo AnimalScreen.kt
            }
        }
    }
}
