package com.example.beautyandfashion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.beautyandfashion.ui.screen.features.*
import com.example.beautyandfashion.ui.screen.home.HomeScreen
import com.example.beautyandfashion.ui.screen.settings.SettingsScreen
import com.example.beautyandfashion.ui.screen.settings.PremiumPlanScreen
import com.example.beautyandfashion.ui.screen.settings.HelpScreen
import com.example.beautyandfashion.ui.screen.wardrobe.WardrobeScreen
import com.example.beautyandfashion.ui.screen.wardrobe.AddItemScreen
import com.example.beautyandfashion.ui.screen.welcome.LoginScreen
import com.example.beautyandfashion.ui.screen.welcome.SignUpScreen
import com.example.beautyandfashion.ui.screen.welcome.WelcomeScreen
import com.example.beautyandfashion.ui.screen.features.ColorMatch.ColorAnalysisScreen
import com.example.beautyandfashion.ui.screen.features.Beautypedia.ArticleDetailScreen
import com.example.beautyandfashion.ui.screen.features.Beautypedia.BeautypediaScreen
import com.example.beautyandfashion.ui.screen.features.ColorMatch.ResultScreen
import com.example.beautyandfashion.ui.screen.features.SkinAnalysis.SkinAnalysisScreen
import com.example.beautyandfashion.ui.screen.features.SkinAnalysis.SkinResultScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("signUp") { SignUpScreen(navController) }
        composable("home") { HomeScreen(navController) }
        composable("wardrobe") { WardrobeScreen(navController) }
        composable("settings") { SettingsScreen(navController) }
        composable("help") { HelpScreen(navController) }
        composable("body") { BodyShapeScreen(navController) }
        composable("color") { ColorAnalysisScreen(navController) }
        composable("skin") { SkinAnalysisScreen(navController) }
        composable("wiki") { BeautypediaScreen(navController) }
        composable("premium") { PremiumPlanScreen(navController) }
        composable("result/{season}") { backStackEntry ->
            val season = backStackEntry.arguments?.getString("season") ?: "Unknown"
            ResultScreen(seasonType = season, navController = navController)
        }
        composable(
            route = "skinResult/{skinType}",
            arguments = listOf(navArgument("skinType") { type = NavType.StringType })
        ) { backStackEntry ->
            val type = backStackEntry.arguments?.getString("skinType") ?: "Normal"
            SkinResultScreen(navController = navController, skinType = type)
        }
        composable(
            "articleDetail/{articleId}",
            arguments = listOf(navArgument("articleId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("articleId") ?: 0
            ArticleDetailScreen(articleId = id, navController = navController)
        }
        composable("add_item/{category}") { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: "unknown"
            AddItemScreen(navController, category)
        }
    }
}
