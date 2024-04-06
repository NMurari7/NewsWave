package com.example.newswave.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.newswave.database.ArticleEntity
import com.example.newswave.database.ArticleRepository
import kotlinx.coroutines.launch


class MainViewModel(private val repository: ArticleRepository) : ViewModel() {

    //    val articles: LiveData<List<ArticleEntity>> = repository.getAllArticles()
    private val _articles: LiveData<List<ArticleEntity>> = repository.getAllArticles()

    val articles: LiveData<List<ArticleEntity>>
        get() = _articles

    var selectedArticle by mutableStateOf<ArticleEntity?>(null)
        private set

    fun addSelectedArticle(article : ArticleEntity){
        selectedArticle = article
    }

    init {
        viewModelScope.launch {
            repository.fetchArticlesFromApi()
        }
    }
}

class MainViewModelFactory(private val repository: ArticleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
