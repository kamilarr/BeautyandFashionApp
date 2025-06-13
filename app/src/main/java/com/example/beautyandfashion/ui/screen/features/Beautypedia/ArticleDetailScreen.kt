package com.example.beautyandfashion.ui.screen.features.Beautypedia

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.beautyandfashion.ui.screen.features.Beautypedia.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(articleId: Int, navController: NavController) {
    // Dummy data (harus disesuaikan dengan real data atau ViewModel)
    val article = getDummyArticleById(articleId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(article.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = article.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(article.title, style = MaterialTheme.typography.headlineSmall)
            Text(
                "${article.category} | ${article.author} | ${article.date}",
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("This is the full article content for ID ${article.id}. You can replace this with actual content.")

            // Tambahkan dummy paragraf panjang agar terlihat bisa scroll
            Spacer(modifier = Modifier.height(16.dp))
            Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
        }
    }
}