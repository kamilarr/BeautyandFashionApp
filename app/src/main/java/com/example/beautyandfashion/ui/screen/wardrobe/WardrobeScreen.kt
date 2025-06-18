package com.example.beautyandfashion.ui.screen.wardrobe

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.beautyandfashion.R
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.component.AppTopBar
import com.example.beautyandfashion.ui.component.BottomBar
import com.example.beautyandfashion.ui.theme.BrownDark

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
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.Top
        ) {

            SectionWithFilterAndGrid(
                title = "Upper Body",
                navController = navController,
                category = "upper_body"
            )

            Spacer(modifier = Modifier.height(16.dp))

            SectionWithFilterAndGrid(
                title = "Lower Body",
                navController = navController,
                category = "lower_body"
            )

            Spacer(modifier = Modifier.height(16.dp))

            SectionWithFilterAndGrid(
                title = "Lower Body",
                navController = navController,
                category = "shoes"
            )
        }
    }
}

@Composable
fun SectionWithFilterAndGrid(
    title: String,
    navController: NavController,
    category: String
) {
    val items = listOf("+", "item1", "item2")

    // Tentukan gambar berdasarkan kategori
    val images = when (category) {
        "upper_body" -> listOf(R.drawable.zjacket, R.drawable.ztshirt2)
        "lower_body" -> listOf(R.drawable.xjeans, R.drawable.xminiskirt)
        "shoes" -> listOf(R.drawable.ysneakers, R.drawable.ywedges)
        else -> listOf(R.drawable.zjacket, R.drawable.zjacket)
    }

    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = BrownDark
            ),
            modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items.forEachIndexed { index, item ->
                Surface(
                    modifier = Modifier.size(120.dp),
                    color = if (item == "+") BrownDark else MaterialTheme.colorScheme.surface,
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 4.dp
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.clickable {
                            if (item == "+") {
                                navController.navigate("add_item/$category")
                            }
                        }
                    ) {
                        if (item == "+") {
                            Text(
                                "+",
                                color = Color.White,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        } else {
                            Image(
                                painter = painterResource(id = images[index - 1]),
                                contentDescription = "Item Image",
                                modifier = Modifier.size(110.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp)) // spacing section
    }
}