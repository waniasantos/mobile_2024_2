package com.example.bestiaryapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bestiaryapp.models.Besty
import com.example.bestiaryapp.models.BestyList
import com.example.bestiaryapp.ui.components.BottomBarScreen
import com.example.bestiaryapp.ui.components.BottomNavigationBar
import com.example.bestiaryapp.ui.screens.HomeScreen
import com.example.bestiaryapp.ui.screens.FavoritesScreen
import com.example.bestiaryapp.ui.screens.DetailsScreen

@ExperimentalMaterial3Api
@Composable
fun NavGraph(
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    val navController = rememberNavController()

    val favoriteBesties = mutableListOf<Besty>().apply {
        addAll(BestyList.filter { it.id % 2 == 0 })
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomBarScreen.Home.route) {
                HomeScreen(
                    bestyList = BestyList,
                    onBestySelected = { besty ->
                        navController.navigate("details/${besty.id}")
                    },
                    onFavoriteToggle = { besty ->
                        if (favoriteBesties.contains(besty)) {
                            favoriteBesties.remove(besty)
                        } else {
                            favoriteBesties.add(besty)
                        }
                    },
                    onSettingsClick = onSettingsClick,
                    onHelpClick = onHelpClick
                )
            }

            composable(BottomBarScreen.Favorites.route) {
                FavoritesScreen(
                    favoriteBesties = favoriteBesties,
                    onBestySelected = { besty ->
                        navController.navigate("details/${besty.id}")
                    },
                    onFavoriteToggle = { besty ->
                        if (favoriteBesties.contains(besty)) {
                            favoriteBesties.remove(besty)
                        } else {
                            favoriteBesties.add(besty)
                        }
                    }
                )
            }

            composable("details/{bestyId}") { backStackEntry ->
                val bestyId = backStackEntry.arguments?.getString("bestyId")?.toIntOrNull()
                val selectedBesty = BestyList.firstOrNull { it.id == bestyId }

                selectedBesty?.let {
                    DetailsScreen(besty = it)
                }
            }
        }
    }
}
