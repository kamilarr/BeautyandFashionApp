package com.example.beautyandfashion.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.component.FeatureCard
import com.example.beautyandfashion.ui.theme.BrownDark
import com.example.beautyandfashion.ui.theme.BrownMedium

data class Feature(val title: String, val description: String, val route: String)

@Composable
fun HomeScreen(navController: NavController) {
    val features = listOf(
        Feature("Color Match", "Discover your ideal colors", "color"),
        Feature("Skin Analysis", "Know your skin type", "skin"),
        Feature("Body Shape", "Find your perfect fit", "body"),
        Feature("WikiBeauty", "Beauty tips & facts", "wiki")
    )

    Scaffold(
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
            Text(
                text = "Hi Jasmine 👋",
                style = MaterialTheme.typography.headlineSmall,
                color = BrownMedium
            )

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
                        onClick = {
                            navController.navigate(feature.route)
                        }
                    )
                }
            }
        }
    }
}
