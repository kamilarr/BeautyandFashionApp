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
import com.example.beautyandfashion.ui.screen.wardrobe.WardrobeScreen
import com.example.beautyandfashion.ui.screen.welcome.LoginScreen
import com.example.beautyandfashion.ui.screen.welcome.SignUpScreen
import com.example.beautyandfashion.ui.screen.welcome.WelcomeScreen
import com.example.beautyandfashion.ui.screen.features.colormatch.ColorAnalysisScreen
import com.example.beautyandfashion.ui.theme.SkinType
import com.example.beautyandfashion.ui.screen.features.Beautypedia.ArticleDetailScreen
import com.example.beautyandfashion.ui.screen.features.Beautypedia.BeautypediaScreen

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
        composable("body") { BodyShapeScreen(navController) }
        composable("color") { ColorAnalysisScreen(navController) }
        composable("skin") { SkinAnalysisScreen(navController) }
        composable("wiki") { BeautypediaScreen(navController) }
        composable("skinStep2") { SkinAnalysisStep2(navController) }
        composable("skinStep3") { SkinAnalysisStep3(navController) }
        composable("skinStep4") { SkinAnalysisStep4(navController) }
        composable("skinStep5") { SkinAnalysisStep5(navController) }
        composable("skinStep6") { SkinAnalysisStep6(navController) }
        composable("skinStep7") { SkinAnalysisStep7(navController) }
        composable(
            route = "skinResult/{skinType}",
            arguments = listOf(navArgument("skinType") { type = NavType.StringType })
        ) { backStackEntry ->
            val typeString = backStackEntry.arguments?.getString("skinType") ?: "NORMAL"
            val skinType = runCatching { SkinType.valueOf(typeString.uppercase()) }
                .getOrDefault(SkinType.NORMAL)
            SkinAnalysisScreen(navController = navController, skinType = skinType)
            }
        composable(
            "articleDetail/{articleId}",
            arguments = listOf(navArgument("articleId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("articleId") ?: 0
            ArticleDetailScreen(articleId = id, navController = navController)
        }

    }
}
