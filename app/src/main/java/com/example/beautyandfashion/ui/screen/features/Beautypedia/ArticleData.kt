package com.example.beautyandfashion.ui.screen.features.Beautypedia

import com.example.beautyandfashion.R

fun getDummyArticleById(id: Int): Article {
    return getDummyArticles().firstOrNull { it.id == id } ?: getDummyArticles().first()
}

fun getDummyArticles(): List<Article> {
    return listOf(
        Article(
            id = 1,
            title = "How to get clear skin fast",
            author = "Dr. Wade Warren",
            date = "June 8, 2025",
            category = "Skincare",
            summary = "Many people find it difficult to get clear skin. The methods for getting clear skin...",
            imageRes = R.drawable.article1
        ),
        Article(
            id = 2,
            title = "Simple skincare routine for beginners",
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
}
