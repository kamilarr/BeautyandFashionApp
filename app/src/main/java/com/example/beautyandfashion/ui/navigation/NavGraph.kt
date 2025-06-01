package com.example.beautyandfashion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beautyandfashion.ui.screen.features.BodyShapeScreen
import com.example.beautyandfashion.ui.screen.home.HomeScreen
import com.example.beautyandfashion.ui.screen.settings.SettingsScreen
import com.example.beautyandfashion.ui.screen.wardrobe.WardrobeScreen
import com.example.beautyandfashion.ui.screen.welcome.WelcomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") { WelcomeScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("wardrobe") { WardrobeScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("body") { BodyShapeScreen(navController) }
    }
}
