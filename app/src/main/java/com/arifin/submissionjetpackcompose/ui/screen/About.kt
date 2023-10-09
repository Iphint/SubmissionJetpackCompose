package com.arifin.submissionjetpackcompose.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arifin.submissionjetpackcompose.R

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    onBackClick:() -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Red,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
            )
            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .height(360.dp)
                    .padding(16.dp)
                    .clip(CircleShape),
                painter = painterResource(R.drawable.my_self),
                contentDescription = "profile"
            )
        }
        item {
            Spacer(modifier = Modifier.height(30.dp))
        }
        item {
            Text(
                text = stringResource(R.string.name),
                style = TextStyle(fontSize = 24.sp),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.fillMaxWidth(1f),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
        }
        item {
            Text(
                text = stringResource(R.string.email),
                style = TextStyle(fontSize = 18.sp),
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.fillMaxWidth(1f),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun AboutScreenPreview() {
    AboutScreen(onBackClick = {})
}