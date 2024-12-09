package com.example.bestiaryapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        )
                }
            )
        }
    ) { innerPadding ->
        if (favoriteBesties.isEmpty()) {
            Text(
                text = "Nenhum personagem favorito encontrado.",
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 8.dp)
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
