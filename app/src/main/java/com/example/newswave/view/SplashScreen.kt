package com.example.newswave.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newswave.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 8000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(6000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(Color(0xff010e21))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(painter = painterResource(id = R.drawable.icon), contentDescription = "",
            modifier = Modifier
                .size(120.dp)
                .alpha(alpha = alpha).clip(RoundedCornerShape(4.dp))
            )
    }
}


@Composable
@Preview
fun SplashScreenPreview(){
//    SplashScreen()
}