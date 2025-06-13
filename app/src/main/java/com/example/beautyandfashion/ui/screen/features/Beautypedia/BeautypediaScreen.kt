package com.example.beautyandfashion.ui.screen.features.Beautypedia

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.screen.features.Beautypedia.Article
import com.example.beautyandfashion.ui.screen.features.Beautypedia.ArticleCard
import com.example.beautyandfashion.R
import com.example.beautyandfashion.ui.component.AppTopBar
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeautypediaScreen(navController: NavController) {
    val articles = listOf(
        Article(
            id = 1,
            title = "How to get clear skin fast",
            author = "Dr. Wade Warren",
            date = "Jan 20, 2021",
            category = "Skincare",
            summary = "Many people find it difficult to get clear skin. The methods for getting clear skin...",
            imageRes = R.drawable.article1
        ),
        Article(
            id = 2,
            title = "How to get clear skin fast",
            author = "Dr. Wade Warren",
            date = "Jan 20, 2021",
            category = "Skincare",
            summary = "Many people find it difficult to get clear skin. The methods for getting clear skin...",
            imageRes = R.drawable.article2
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
