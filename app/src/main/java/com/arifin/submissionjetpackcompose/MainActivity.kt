package com.arifin.submissionjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arifin.submissionjetpackcompose.ui.navigation.Navigation
import com.arifin.submissionjetpackcompose.ui.screen.FoodApp
import com.arifin.submissionjetpackcompose.ui.screen.SplashScreen
import com.arifin.submissionjetpackcompose.ui.theme.SubmissionJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SubmissionJetpackComposeTheme {
                Navigation()
            }
        }
    }
}