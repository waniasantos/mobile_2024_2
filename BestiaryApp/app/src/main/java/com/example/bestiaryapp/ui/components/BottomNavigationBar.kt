package com.example.bestiaryapp.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bestiaryapp.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorites
    )

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = screen.icon,
                label = { Text(screen.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    indicatorColor = MaterialTheme.colorScheme.inversePrimary
                )
            )
        }
    }
}

sealed class BottomBarScreen(val route: String, val icon: @Composable () -> Unit, val label: String) {

    object Home : BottomBarScreen(
        route = "home",
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.outro_lado),
                contentDescription = "Home Icon",
                modifier = Modifier.size(24.dp)
            )
        },
        label = "Bestiário"
    )

    object Favorites : BottomBarScreen(
        route = "favorites",
        icon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorites Icon",
                modifier = Modifier.size(24.dp)
            )
        },
        label = "Favoritos"
    )
}
