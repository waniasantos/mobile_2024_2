package com.example.zooapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.zooapp.R
import com.example.zooapp.models.Animal
import com.example.zooapp.models.animalList
import com.example.zooapp.ui.components.AnimalListItem

@Composable
fun HomeScreen(onAnimalSelected: (Animal) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    val filteredAnimals = remember(searchQuery) {
        animalList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    Column {
        SearchBar(
            searchQuery = searchQuery,
            onSearchQueryChanged = { searchQuery = it },
            onClearClick = { searchQuery = "" }
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            items(filteredAnimals) { animal ->
                AnimalListItem(animal, onAnimalSelected)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    onClearClick: () -> Unit
) {
    TextField(
        value = searchQuery,
        onValueChange = onSearchQueryChanged,
        placeholder = { Text("Pesquisar animais") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.lupa_busca),
                contentDescription = "Ícone de busca",
                modifier = Modifier
                    .size(28.dp)
                    .padding(start = 8.dp),
                tint = colorResource(id = R.color.black_desatureted)
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = onClearClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.limpar_busca),
                        contentDescription = "Limpar busca",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(end = 8.dp),
                        tint = colorResource(id = R.color.black_desatureted)
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(56.dp),
        shape = RoundedCornerShape(28.dp), 
        colors = TextFieldDefaults.textFieldColors(
            containerColor = colorResource(id = R.color.blue_paws_desaturated),
            focusedTextColor = colorResource(id = R.color.black_desatureted),
            unfocusedTextColor = colorResource(id = R.color.black_desatureted),
            focusedPlaceholderColor = colorResource(id = R.color.black),
            unfocusedPlaceholderColor = colorResource(id = R.color.black),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}
