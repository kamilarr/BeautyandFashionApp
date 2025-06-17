@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.beautyandfashion.ui.screen.wardrobe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.AppTopBar
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.theme.BrownDark
import androidx.compose.foundation.clickable

@Composable
fun WardrobeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                title = "My Wardrobe",
                onBack = null,
                icon = null
            )
        } ,
        bottomBar = {
            BottomBar(navController, "wardrobe")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.Top
        ) {
            // Section: Upper Body
            SectionWithFilterAndGrid(
                title = "Upper Body",
                filters = listOf("All Upper Body", "Jackets", "Tops"),
                navController = navController
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Section: Lower Body
            SectionWithFilterAndGrid(
                title = "Lower Body",
                filters = listOf("All Upper Body", "Jackets", "Tops"),
                navController = navController
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Section: Shoes
            SectionWithFilterAndGrid(
                title = "Shoes",
                filters = listOf("All Upper Body", "Jackets", "Tops"),
                navController = navController
            )
        }
    }
}

@Composable
fun SectionWithFilterAndGrid(title: String, filters: List<String>, navController: NavController) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = BrownDark
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            filters.forEach { filter ->
                Button(
                    onClick = { /* Handle filter click if needed */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (filter.contains("All")) BrownDark else MaterialTheme.colorScheme.surfaceVariant,
                        contentColor = if (filter.contains("All")) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(filter)
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            listOf("+", "item", "item").forEach { item ->
                Surface(
                    modifier = Modifier.size(100.dp),
                    color = if (item == "+") BrownDark else MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 4.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.clickable {
                            if (item == "+") {
                                navController.navigate("add_item")
                            }
                        }
                    ) {
                        if (item == "+") {
                            Text("+", color = MaterialTheme.colorScheme.onPrimary, style = MaterialTheme.typography.headlineLarge)
                        } else {
                            Text("\uD83D\uDC57", fontSize = MaterialTheme.typography.headlineLarge.fontSize)
                        }
                    }
                }
            }
        }
    }
}
