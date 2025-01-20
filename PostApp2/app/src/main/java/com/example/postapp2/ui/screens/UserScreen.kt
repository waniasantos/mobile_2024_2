package com.example.postapp2.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import com.example.postapp2.viewModel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(viewModel: PostViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchUsers()
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Cadastro de Usuário",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nome") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary
            )
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary
            )
        )

        Button(
            onClick = {
                isLoading = true
                viewModel.createUser(name, email, onSuccess = {
                    Toast.makeText(context, "Usuário criado com sucesso!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                }, onError = {
                    Toast.makeText(context, "Erro ao criar o usuário!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                })
                name = ""
                email = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Criar Usuário", fontSize = 16.sp)
        }

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colorScheme.primary
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                items(viewModel.users) { user ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.tertiary,
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Nome: ${user.name}",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondary,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Email: ${user.email}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.8f)
                            )
                        }
                    }
                }
            }
        }
    }
}