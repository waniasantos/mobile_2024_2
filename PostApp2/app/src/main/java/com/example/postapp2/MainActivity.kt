package com.example.postapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.postapp2.ui.theme.PostApp2Theme

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.postapp2.ui.screens.PostScreen
import com.example.postapp2.ui.screens.UserScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    var selectTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { "PostApp" },
                backgroundColor = MaterialTheme.colorScheme.secondary,
                contentColor = Color.White
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                NavigationBarItem(
                    selected = selectTab == 0,
                    onClick = { selectTab = 0 },
                    label = {
                        Text(
                            "Usuários",
                            color = if (selectTab == 0)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.6f)
                        )
                    },
                    icon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Usuarios",
                            tint = if (selectTab == 0)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                        indicatorColor = MaterialTheme.colorScheme.secondary
                    )
                )

                NavigationBarItem(
                    selected = selectTab == 1,
                    onClick = { selectTab = 1 },
                    label = {
                        Text(
                            "Posts",
                            color = if (selectTab == 1)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
                        )
                    },
                    icon = {
                        Icon(
                            Icons.Default.List,
                            contentDescription = "Posts",
                            tint = if (selectTab == 1)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                        indicatorColor = MaterialTheme.colorScheme.secondary
                    )
                )
            }
        }
    ) {
        when (selectTab) {
            0 -> UserScreen()
            1 -> PostScreen()
        }
    }
}