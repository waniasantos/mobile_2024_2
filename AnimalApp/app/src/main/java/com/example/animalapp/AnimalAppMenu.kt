package com.example.animalapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

@Composable
fun AnimalAppMenu(onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    val doguinhaText = stringResource(R.string.menu_doguinha)
    val catinhaText = stringResource(R.string.menu_catinha)

    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = stringResource(R.string.menu_content_description))
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text(stringResource(R.string.menu_doguinha)) },
            onClick = {
                expanded = false
                onOptionSelected(doguinhaText)
            }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.menu_catinha)) },
            onClick = {
                expanded = false
                onOptionSelected(catinhaText)
            }
        )
    }
}

