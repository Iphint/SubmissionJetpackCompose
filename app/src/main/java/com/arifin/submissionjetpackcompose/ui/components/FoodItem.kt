package com.arifin.submissionjetpackcompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arifin.submissionjetpackcompose.R
import com.arifin.submissionjetpackcompose.ui.model.Makanan

@Composable
fun FoodItem(makanan: Makanan, onFoodClick: (Makanan) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onFoodClick(makanan) }
    ) {
        Image(
            painter = painterResource(id = makanan.food_picture),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = makanan.food_name,
            style = TextStyle(fontSize = 24.sp),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = makanan.food_country,
            style = TextStyle(fontSize = 18.sp),
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
fun previewFoodItem() {
    val sampleMakanan = Makanan(
        id = 1,
        food_name = "Nama Makanan",
        food_country = "Negara Asal",
        food_picture = R.drawable.sashimi,
        description = "Makanan enak sekali"
    )

    FoodItem(makanan = sampleMakanan) {
        // Handle food item click action here
    }
}
