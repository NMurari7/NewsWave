package com.example.newswave

import ApiService
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.newswave.database.AppDatabase
import com.example.newswave.database.ArticleRepository
import com.example.newswave.ui.theme.NewsWaveTheme
import com.example.newswave.view.HomeScreen
import com.example.newswave.view.SplashScreen
import com.example.newswave.viewmodel.MainViewModel
import com.example.newswave.viewmodel.MainViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newswave.view.ArticlePage
import com.example.newswave.view.Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsWaveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val userDao = AppDatabase.getDatabase(this).roomDao()
                    val retrofit = Retrofit.Builder().baseUrl("https://gnews.io/api/v4/")
                        .addConverterFactory(GsonConverterFactory.create()).build()
                    val apiObj: ApiService = retrofit.create(ApiService::class.java)
                    val repository: ArticleRepository = ArticleRepository(userDao, apiObj)
                    val viewModel: MainViewModel by viewModels {
                        MainViewModelFactory(repository)
                    }
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.Splash.route) {
                        composable(route = Screen.Splash.route) {
                            SplashScreen(navController = navController)
                        }
                        composable(route = Screen.Home.route) {backStackEntry ->
                            HomeScreen(mainViewModel = viewModel, navController = navController)
                        }
                        
                        composable(route = Screen.Article.route ){
                            ArticlePage(mainViewModel = viewModel, navController = navController)
                        }
                    }

//                    HomeScreen(mainViewModel = viewModel)
//                    SplashScreen()
//                    AtriclePage("https://www.investors.com/wp-content/uploads/2019/12/Stock-TradingMarket-05-adobe.jpg",
//                        "Buy Points Get A Historic Change. How Tesla Stock Rally Started With The Correct Entry",
//                        "Buy Point Rule: IBD's new buy point rule is jettisoning the 10-cent addition to the pivot. Tesla's example shows how trendline entries work very well.",
//                        "How do you find the right buy point for a stock? Well, the short answer used to be that you add 10 cents to the most recent high in a well-defined chart pattern.\nX\nBut that is changing. IBD has jettisoning the 10-cent cushion for some important reaso... [2274 chars]")
//                }
                }
            }
        }
    }
}