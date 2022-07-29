package com.mumaralfajar.newsapp.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.mumaralfajar.newsapp.presentation.ui.theme.Grey
import com.mumaralfajar.newsapp.R

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun ViewEmpty() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.no_content),
            contentDescription = "",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
        )

        Text(
            text = "there is no news here for now",
            style = TextStyle(
                color = Grey,
                fontFamily = FontFamily.SansSerif,
                fontSize = 14.sp
            ),
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}