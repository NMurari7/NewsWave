package com.example.newswave.database


import ApiService
import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArticleRepository(private val articleDao: ArticleDao, private val apiService: ApiService) {

    // Function to get all articles from the database
    fun getAllArticles(): LiveData<List<ArticleEntity>> {
        return articleDao.getAllArticles()
    }

    // Function to insert articles into the database
    suspend fun insertArticles(articles: List<ArticleEntity>) {
        articleDao.insertArticles(articles)
    }

    // Function to delete all articles from the database
    suspend fun deleteAllArticles() {
        articleDao.deleteAllArticles()
    }

    // Function to fetch articles from the API and insert into the database
    suspend fun fetchArticlesFromApi() {
        try {
            val articles = apiService.getArticles("general", "en", "in", 10, "cdcaceb9a8ac1a4e8fa2ea126ead15e9").articles
            insertArticles(articles.map { article ->
                ArticleEntity(
                    title = article.title,
                    content = article.content,
                    description = article.description,
                    image = article.image
                )
            })
        } catch (e: Exception) {
            Log.d("Fail Checker", "Error occured while fetching and inserting data")
        }
    }
}
