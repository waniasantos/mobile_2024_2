package com.example.bestiaryapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bestiaryapp.models.Besty
import com.example.bestiaryapp.ui.components.BestyListItem

@ExperimentalMaterial3Api
@Composable
fun FavoritesScreen(
    favoriteBesties: List<Besty>,
    onBestySelected: (Besty) -> Unit,
    onFavoriteToggle: (Besty) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Favoritos",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        if (favoriteBesties.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nenhum personagem favorito encontrado.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
            ) {
                items(favoriteBesties) { besty ->
                    BestyListItem(
                        besty = besty,
                        onBestySelected = { onBestySelected(it) },
                        onFavoriteToggle = { onFavoriteToggle(it) },
                        isFavorite = true
                    )
                }
            }
        }
    }
}
