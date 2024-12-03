package com.example.zooapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zooapp.R
import com.example.zooapp.models.Animal

@ExperimentalMaterial3Api
@Composable
fun AnimalScreen(animal: Animal, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = animal.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 36.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp), 
                        color = colorResource(id = R.color.blue_paws) 
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) { 
                        Icon(
                            painter = painterResource(id = R.drawable.seta_voltar), 
                            contentDescription = "Voltar",
                            tint = colorResource(id = R.color.blue_paws) 
                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.white) 
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = animal.imageRes),
                contentDescription = "${animal.name} Image",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = animal.species,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = animal.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Curiosidade: ${animal.curiosities}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}
