package com.example.newswave.view

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Article : Screen("article_screen")
}