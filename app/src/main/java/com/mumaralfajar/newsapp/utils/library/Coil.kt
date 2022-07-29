package com.mumaralfajar.newsapp.utils.library

import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.mumaralfajar.newsapp.R

@ExperimentalCoilApi
@Composable
fun paintImage(image: String): ImagePainter {
    return rememberImagePainter(
        data = image,
        builder = {
            placeholder(R.drawable.placeholder)
            error(R.drawable.placeholder)
        }
    )
}