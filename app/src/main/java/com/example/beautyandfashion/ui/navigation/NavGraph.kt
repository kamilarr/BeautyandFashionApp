package com.example.beautyandfashion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beautyandfashion.ui.screen.features.BeautypediaScreen
import com.example.beautyandfashion.ui.screen.features.BodyShapeScreen
import com.example.beautyandfashion.ui.screen.features.ColorAnalysisScreen
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisResult
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisScreen
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisStep2
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisStep3
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisStep4
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisStep5
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisStep6
import com.example.beautyandfashion.ui.screen.features.SkinAnalysisStep7
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
        composable("color") { ColorAnalysisScreen(navController) }
        composable("skin") { SkinAnalysisScreen(navController) }
        composable("wiki") { BeautypediaScreen(navController) }
        composable("skinStep2") { SkinAnalysisStep2(navController)  }
        composable("skinStep3") { SkinAnalysisStep3(navController)  }
        composable("skinStep4") { SkinAnalysisStep4(navController) }
        composable("skinStep5") { SkinAnalysisStep5(navController)  }
        composable("skinStep6") { SkinAnalysisStep6(navController) }
        composable("skinStep7") { SkinAnalysisStep7(navController) }
        composable("skinResult") { SkinAnalysisResult(navController)  }



    }
}
