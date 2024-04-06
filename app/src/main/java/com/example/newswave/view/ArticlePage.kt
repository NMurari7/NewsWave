package com.example.newswave.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.newswave.viewmodel.MainViewModel

@Composable
fun ArticlePage(mainViewModel: MainViewModel, navController: NavController){
    val img : String = mainViewModel.selectedArticle?.image.toString()
    val title:String = mainViewModel.selectedArticle?.title.toString()
    val description:String = mainViewModel.selectedArticle?.description.toString()
    val content:String = mainViewModel.selectedArticle?.content.toString()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column {
            Image(painter = rememberAsyncImagePainter(img), contentDescription ="",
                modifier = Modifier.fillMaxWidth()
                    .height(350.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillBounds
            )

//            Text(text = title, color = Color(0xFFD1C1C1), fontSize = 24.sp, fontFamily = FontFamily.Serif,fontWeight = FontWeight.Bold ,modifier = Modifier.padding(start = 14.dp, end = 14.dp), maxLines = 4, overflow = TextOverflow.Ellipsis)
//
//            Text(text = description, color = Color(0xFFD1C1C1), fontSize = 18.sp, fontFamily = FontFamily.Serif,fontWeight = FontWeight.SemiBold ,modifier = Modifier.padding(start = 14.dp, end = 14.dp), overflow = TextOverflow.Ellipsis)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp, fontFamily = FontFamily.Serif, color = Color(0xFFD1C1C1))) {
                            append(title)
                        }
                        append("\n")
                        withStyle(style = SpanStyle(color = Color(0xFFD1C1C1), fontSize = 18.sp, fontFamily = FontFamily.Serif, fontWeight = FontWeight.Bold)) {
                            append(description)
                        }
                        append("\n")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold, fontSize = 18.sp)) {
                            append(content)
                        }
                    },
                    color = Color(0xFFD1C1C1),
                    fontSize = 18.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 14.dp, end = 14.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Int.MAX_VALUE // Set maxLines to Int.MAX_VALUE to allow unlimited lines
                )

            }
//            Text(text = content, color = Color(0xFFD1C1C1), fontSize = 18.sp, fontFamily = FontFamily.Serif,fontWeight = FontWeight.SemiBold ,modifier = Modifier.padding(start = 14.dp, end = 14.dp), overflow = TextOverflow.Ellipsis)

        }
    }
}

//@Composable
//@Preview
//fun ArticlePagePreview(){
//    ArticlePage("https://www.investors.com/wp-content/uploads/2019/12/Stock-TradingMarket-05-adobe.jpg",
//        "Buy Points Get A Historic Change. How Tesla Stock Rally Started With The Correct Entry",
//        "Buy Point Rule: IBD's new buy point rule is jettisoning the 10-cent addition to the pivot. Tesla's example shows how trendline entries work very well.",
//        "How do you find the right buy point for a stock? Well, the short answer used to be that you add 10 cents to the most recent high in a well-defined chart pattern.\nX\nBut that is changing. IBD has jettisoning the 10-cent cushion for some important reaso... [2274 chars]")
//}
