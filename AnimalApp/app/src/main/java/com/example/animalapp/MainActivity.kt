package com.example.animalapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animalapp.ui.theme.AnimalAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HomeScreen { animal ->
                        val intent = Intent(this, AnimalScreenActivity::class.java)
                        intent.putExtra("animal", animal)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}
