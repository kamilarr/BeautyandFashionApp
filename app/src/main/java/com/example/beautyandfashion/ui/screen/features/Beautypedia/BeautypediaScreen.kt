package com.example.beautyandfashion.ui.screen.features.Beautypedia

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.beautyandfashion.R
import com.example.beautyandfashion.ui.component.AppTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeautypediaScreen(navController: NavController) {
    val articles = listOf(
        Article(
            id = 1,
            title = "How to Get Clear Skin Fast",
            author = "Dr. Wade Warren",
            date = "June 8, 2025",
            category = "Skincare",
            summary = "Many people find it difficult to get clear skin. The methods for getting clear skin...",
            imageRes = R.drawable.article1
        ),
        Article(
            id = 2,
            title = "Simple Skincare Routine for Beginners",
            author = "Dr. Jane Foster",
            date = "May 18, 2025",
            category = "Skincare",
            summary = "A good skincare routine doesn’t need to be complicated. Here’s a beginner-friendly routine...",
            imageRes = R.drawable.article2
        ),
        Article(
            id = 3,
            title = "The Rise of Skin Cycling: A Smarter Way to Use Your Skincare",
            author = "Dr. Emily Larson",
            date = "June 15, 2025",
            category = "Skincare",
            summary = "Skin cycling is a trending skincare method that balances active ingredients and recovery days to reduce irritation and improve results. ...",
            imageRes = R.drawable.article3
        )
    )

    Scaffold(
        topBar = {
            AppTopBar(
                title = "BEAUTYPEDIA",
                onBack = { navController.popBackStack() },
                icon = null
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 80.dp)
            ) {
                items(articles) { article ->
                    ArticleCard(article) {
                        navController.navigate("articleDetail/${article.id}")
                    }
                }
            }

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Scroll down",
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .size(48.dp)
                    .alpha(0.3f)
            )
        }
    }
}
