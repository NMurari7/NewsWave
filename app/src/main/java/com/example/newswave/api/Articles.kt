package com.example.newswave.api

data class Source(
    val name: String,
    val url: String
)

data class Article(
    val content: String,
    val description: String,
    val image: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String
)

data class Articles(
    val articles: List<Article>,
    val totalArticles: Int
)
