package com.arifin.submissionjetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arifin.submissionjetpackcompose.R
import com.arifin.submissionjetpackcompose.ui.model.Makanan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailFood(makanan: Makanan, onBackClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = { Text(text = makanan.food_name) },
            navigationIcon = {
                IconButton(onClick = { onBackClick() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = makanan.food_picture),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = makanan.food_name,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location Icon",
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = makanan.food_country,
                style = TextStyle(fontSize = 17.sp, color = Color.Magenta),
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = makanan.description,
            style = TextStyle(fontSize = 18.sp),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailFoodPreview() {
    val sampleFood = Makanan(
        id = 1,
        food_name = "Nasi Goreng",
        description = "Nasi goreng dengan berbagai topping pilihan.",
        food_picture = R.drawable.food_banner,
        food_country = "india",
    )

    DetailFood(makanan = sampleFood, onBackClick = {})
}
