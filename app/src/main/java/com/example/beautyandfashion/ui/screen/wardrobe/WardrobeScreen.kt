@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.beautyandfashion.ui.screen.wardrobe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.theme.BrownDark

@Composable
fun WardrobeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Wardrobe") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BrownDark,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
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
                filters = listOf("All Upper Body", "Jackets", "Tops")
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Section: Lower Body
            SectionWithFilterAndGrid(
                title = "Lower Body",
                filters = listOf("All Lower Body", "Skirts", "Jeans")
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Section: Shoes
            SectionWithFilterAndGrid(
                title = "Shoes",
                filters = listOf("All Shoes", "Heels", "Sneakers")
            )
        }
    }
}

@Composable
fun SectionWithFilterAndGrid(title: String, filters: List<String>) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = BrownDark
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Filters Row
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            filters.forEach { filter ->
                Button(
                    onClick = { /* handle filter click */ },
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

        // Item Grid (3 items with "+" as the first)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            listOf("+", "item", "item").forEach { item ->
                Surface(
                    modifier = Modifier
                        .size(100.dp),
                    color = if (item == "+") BrownDark else MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 4.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        if (item == "+") {
                            Text("+", color = MaterialTheme.colorScheme.onPrimary, style = MaterialTheme.typography.headlineLarge)
                        } else {
                            // Placeholder item (gunakan Image/AsyncImage di implementasi nyata)
                            Text("\uD83D\uDC57", fontSize = MaterialTheme.typography.headlineLarge.fontSize)
                        }
                    }
                }
            }
        }
    }
}