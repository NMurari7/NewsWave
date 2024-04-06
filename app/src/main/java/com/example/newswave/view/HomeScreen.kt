package com.example.newswave.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.newswave.database.ArticleEntity
import com.example.newswave.viewmodel.MainViewModel


@Composable
fun HomeScreen(mainViewModel: MainViewModel, modifier: Modifier = Modifier, navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){
        val articlesList by mainViewModel.articles.observeAsState(emptyList())
        MovieListScreen(articles = articlesList, navController = navController, mainViewModel = mainViewModel)

    }
}

@Composable
fun MovieListScreen(mainViewModel: MainViewModel,articles: List<ArticleEntity>, navController: NavController) {
    LazyVerticalGrid( // Change to LazyHorizontalGrid for horizontal scrolling
        columns = GridCells.Fixed(1), // Adjust the number of columns as needed
        content = {
            items(articles) { article ->
                MovieCard(mainViewModel = mainViewModel, article, navController = navController) // Pass the current movie data
                Divider(modifier = Modifier.padding(start = 20.dp, end = 20.dp) ,thickness = 1.dp, color = Color.LightGray)
            }
        }
    )
}



@Composable
fun MovieCard(mainViewModel: MainViewModel, article: ArticleEntity, navController: NavController){
    Card(modifier = Modifier
        .fillMaxWidth()
//        .fillMaxSize()
//        .width(250.dp)
//        .height(350.dp)
        .padding(8.dp).clickable {
            mainViewModel.addSelectedArticle(article = article)
            navController.navigate(Screen.Article.route)
        }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Black)
        )
        {
//            Image(painter = rememberAsyncImagePainter(movie.big_image) ,



            Image(painter = rememberAsyncImagePainter(article.image), contentDescription ="",
                modifier = Modifier.fillMaxWidth()
                    .height(240.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )

            Text(text = article.title, color = Color(0xFFD1C1C1), fontSize = 24.sp, fontFamily = FontFamily.Serif,fontWeight = FontWeight.Bold ,modifier = Modifier.padding(start = 14.dp, end = 14.dp), maxLines = 4, overflow = TextOverflow.Ellipsis)
//            Text(text = article.description)


        }
    }
}


