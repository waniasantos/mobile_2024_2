package com.example.nighteventsapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun DrawerContent(navController: NavHostController, onSendNotification: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(380.dp)
            .padding(end = 20.dp)
            .background(MaterialTheme.colorScheme.surface),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Menu",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f)
            )

            Text(
                text = "Perfil",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("profile")
                    }
                    .padding(vertical = 8.dp)
            )

            Text(
                text = "Notificação",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onSendNotification()
                    }
                    .padding(vertical = 8.dp)
            )

            Text(
                text = "Sair",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .clickable {
                        navController.navigate("login")
                    }
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Versão 1.0.0",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}



