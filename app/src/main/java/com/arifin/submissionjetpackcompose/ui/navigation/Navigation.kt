package com.arifin.submissionjetpackcompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arifin.submissionjetpackcompose.ui.screen.FoodApp
import com.arifin.submissionjetpackcompose.ui.screen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val splash = "splashScreen"
    val main = "foodApp"
    NavHost(navController, startDestination = "splashScreen") {
        composable(splash) {
            SplashScreen(navController)
        }
        composable(main) {
            FoodApp(navController)
        }
    }
}