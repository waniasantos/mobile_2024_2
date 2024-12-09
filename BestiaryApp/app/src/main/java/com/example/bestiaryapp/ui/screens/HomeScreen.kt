package com.example.bestiaryapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.bestiaryapp.models.Besty
import com.example.bestiaryapp.ui.components.BestyListItem
import com.example.bestiaryapp.ui.components.TopAppBarMenu

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    bestyList: List<Besty>,
    onBestySelected: (Besty) -> Unit,
    onFavoriteToggle: (Besty) -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredBesties = remember(searchQuery) {
        bestyList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Scaffold(
        topBar = {
            TopAppBarMenu(
                onSettingsClick = onSettingsClick,
                onHelpClick = onHelpClick
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            // Barra de busca arredondada
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Pesquisar criatura") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp), // Altura da barra de busca
                shape = RoundedCornerShape(28.dp), // Define bordas arredondadas
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent, // Sem indicador ao focar
                    unfocusedIndicatorColor = Color.Transparent  // Sem indicador sem foco
                )
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(filteredBesties) { besty ->
                    BestyListItem(
                        besty = besty,
                        onBestySelected = { onBestySelected(it) },
                        onFavoriteToggle = { onFavoriteToggle(it) },
                        isFavorite = false
                    )
                }
            }
        }
    }
}
