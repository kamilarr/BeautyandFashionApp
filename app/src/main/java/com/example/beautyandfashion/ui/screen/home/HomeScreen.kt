@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.beautyandfashion.ui.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.R
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.component.FeatureCard
import com.example.beautyandfashion.ui.theme.BrownDark
import com.example.beautyandfashion.ui.theme.BrownMedium


data class Feature(val title: String, val description: String, @DrawableRes val imageRes: Int, val route: String)

@Composable
fun HomeScreen(navController: NavController) {
    val features = listOf(
        Feature("Color Match", "Discover shades that make you pop!", R.drawable.color,"color"),
        Feature("Skin Analysis", "Know your skin. Glow your skin!", R.drawable.skin,"skin"),
        Feature("Body Shape", "Dress for your shape, not trend!", R.drawable.body,"body"),
        Feature("WikiBeauty", "Beauty wisdom at your fingertips!", R.drawable.wikibeauty,"wiki")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Hi Jasmine \uD83D\uDC4B") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BrownDark,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            BottomBar(navController, "home")
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(features) { feature ->
                    FeatureCard(
                        title = feature.title,
                        description = feature.description,
                        imageRes = feature.imageRes,
                        onClick = {
                            navController.navigate(feature.route)
                        }
                    )
                }
            }
        }
    }
}
