package com.example.zooapp.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.zooapp.models.animalList
import com.example.zooapp.ui.screens.AnimalScreen
import com.example.zooapp.ui.screens.HomeScreen

@ExperimentalMaterial3Api
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        // Tela Home
        composable(route = Screen.Home.route) {
            HomeScreen(onAnimalSelected = { animal ->
                navController.navigate(Screen.Animal.createRoute(animal.name))
            })
        }

        // Tela Animal
        composable(
            route = Screen.Animal.route,
            arguments = listOf(navArgument("animalName") { type = NavType.StringType })
        ) { backStackEntry ->
            val animalName = backStackEntry.arguments?.getString("animalName") ?: return@composable
            val selectedAnimal = animalList.firstOrNull { it.name == animalName }
            selectedAnimal?.let { AnimalScreen(it, navController) }
        }
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Animal : Screen("animal/{animalName}") {
        fun createRoute(animalName: String): String = "animal/$animalName"
    }
}
