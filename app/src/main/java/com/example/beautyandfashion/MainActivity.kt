package com.example.beautyandfashion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.beautyandfashion.ui.navigation.NavGraph
import com.example.beautyandfashion.ui.theme.BeautyAndFashionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeautyAndFashionTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
