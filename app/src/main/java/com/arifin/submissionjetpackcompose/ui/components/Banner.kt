package com.arifin.submissionjetpackcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arifin.submissionjetpackcompose.R

@Composable
fun Banner(modifier: Modifier = Modifier, onSearchChanged: (String) -> Unit) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Search(onSearch = onSearchChanged)
        Box(
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun previewBanner() {
    Banner(onSearchChanged = { var searchText = it })
    
}