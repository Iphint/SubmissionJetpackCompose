package com.arifin.submissionjetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.arifin.submissionjetpackcompose.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var navigateToFoodApp by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = navigateToFoodApp) {
        delay(3000)
        navigateToFoodApp = true
    }

    if (navigateToFoodApp) {
        navController.navigate("foodApp")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash     ),
            contentDescription = "Splash Logo",
            modifier = Modifier
                .size(300.dp)
        )
    }
}

@Preview
@Composable
fun previewSplashScreen() {
    val fakeNavController = rememberNavController()
    SplashScreen(fakeNavController)
}