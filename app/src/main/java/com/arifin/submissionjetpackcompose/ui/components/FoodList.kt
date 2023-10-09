package com.arifin.submissionjetpackcompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arifin.submissionjetpackcompose.R
import com.arifin.submissionjetpackcompose.ui.model.Makanan

@Composable
fun FoodList(makanan: List<Makanan>, scrollState: LazyListState, onFoodClick: (Makanan) -> Unit) {
    if (makanan.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Data makanan tidak ditemukan.", style = TextStyle(fontSize = 24.sp))
        }
    } else {
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(makanan.size) { index ->
                val makan = makanan[index]
                FoodItem(makan, onFoodClick)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun previewFoodList() {
    val sampleMakananList = listOf(
        Makanan(
            id = 1,
            food_name = "Makanan 1",
            food_country = "Negara 1",
            food_picture = R.drawable.sushi,
            description = "Sushi enak sekali"
        ),
        Makanan(
            id = 2,
            food_name = "Makanan 2",
            food_country = "Negara 2",
            food_picture = R.drawable.dimsum,
            description = "Dimsum enak sekali"
        ),
    )

    val sampleScrollState = rememberLazyListState()

    FoodList(makanan = sampleMakananList, scrollState = sampleScrollState) {}
}
