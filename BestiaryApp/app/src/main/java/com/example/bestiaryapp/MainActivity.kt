package com.example.bestiaryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.bestiaryapp.navigation.NavGraph
import com.example.bestiaryapp.ui.theme.BestiaryAppTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BestiaryAppTheme {
                NavGraph(
                    onSettingsClick = {
                        // Ação para Configurações
                    },
                    onHelpClick = {
                        // Ação para Ajuda
                    }
                )
            }
        }
    }
}
