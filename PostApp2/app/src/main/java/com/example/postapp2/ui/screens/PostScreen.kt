package com.example.postapp2.ui.screens

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import com.example.postapp2.data.models.Post
import com.example.postapp2.viewModel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun PostScreen(viewModel: PostViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var editingPost by remember { mutableStateOf<Post?>(null) }
    var context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchPosts()
        isLoading = false
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Criar Nova Postagem",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary
            )
        )

        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Conteúdo") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(bottom = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary
            )
        )

        Button(
            onClick = {
                isLoading = true
                viewModel.createPost(title, content, onSuccess = {
                    Toast.makeText(context, "Post criado com sucesso!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                }, onError = {
                    Toast.makeText(context, "Erro ao criar o post!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                })
                title = ""
                content = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Criar Post", fontSize = 16.sp)
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
                items(viewModel.posts) { post ->
                    PostItem(
                        post = post,
                        onDelete = { viewModel.deletePost(it) },
                        onEdit = { editingPost = it }
                    )
                }
            }
        }
    }

    if (editingPost != null) {
        AlertDialog(
            onDismissRequest = { editingPost = null },
            title = { Text("Editar Post") },
            text = {
                Column {
                    OutlinedTextField(
                        value = editingPost!!.title,
                        onValueChange = { newTitle ->
                            editingPost = editingPost!!.copy(title = newTitle)
                        },
                        label = { Text("Título") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = editingPost!!.content,
                        onValueChange = { newContent ->
                            editingPost = editingPost!!.copy(content = newContent)
                        },
                        label = { Text("Conteúdo") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.updatePost(editingPost!!.id, editingPost!!.title, editingPost!!.content)
                    editingPost = null
                }) {
                    Text("Salvar")
                }
            },
            dismissButton = {
                TextButton(onClick = { editingPost = null }) {
                    Text("Cancelar")
                }
            }
        )
    }
}