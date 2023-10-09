package com.arifin.submissionjetpackcompose.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.arifin.submissionjetpackcompose.ui.components.Banner
import com.arifin.submissionjetpackcompose.ui.components.FoodList
import com.arifin.submissionjetpackcompose.ui.icon.UserFAB
import com.arifin.submissionjetpackcompose.ui.model.DataMakanan
import com.arifin.submissionjetpackcompose.ui.model.Makanan

@Composable
fun FoodApp(navController: NavHostController) {
    val scrollState = rememberLazyListState()
    val isScrolled = scrollState.firstVisibleItemIndex > 0 || scrollState.firstVisibleItemScrollOffset > 0

    var showAboutScreen by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    var selectedFood by remember { mutableStateOf<Makanan?>(null) }

    val filteredMakanan = if (searchText.isEmpty()) {
        DataMakanan.makanan
    } else {
        DataMakanan.makanan.filter { it.food_name.contains(searchText, ignoreCase = true) }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        if (showAboutScreen) {
            AboutScreen(onBackClick = { showAboutScreen = false })
        } else if (selectedFood != null) {
            DetailFood(makanan = selectedFood!!) {
                selectedFood = null
            }
        }
        else {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                AnimatedVisibility(
                    visible = !isScrolled,
                    exit = fadeOut(animationSpec = tween(durationMillis = 300))
                ) {
                    Banner(onSearchChanged = { searchText = it })
                }
                FoodList(filteredMakanan, scrollState) { food ->
                    selectedFood = food
                }
            }
            UserFAB(onFABClick = { showAboutScreen = true })
        }
    }
}

@Preview
@Composable
fun previewHomePage() {
    val navController = rememberNavController()
    FoodApp(navController)
}