package com.mumaralfajar.newsapp.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.mumaralfajar.newsapp.model.NewsModel
import com.mumaralfajar.newsapp.presentation.ui.screens.Screen
import com.mumaralfajar.newsapp.presentation.ui.theme.LightGrey
import com.mumaralfajar.newsapp.presentation.ui.theme.RippleGrey
import com.mumaralfajar.newsapp.presentation.ui.theme.RippleWhite
import com.mumaralfajar.newsapp.utils.constants.Constants.NEWS_BUNDLE_KEY
import com.mumaralfajar.newsapp.utils.extentions.putParcelableBundle
import com.mumaralfajar.newsapp.utils.library.paintImage

@ExperimentalCoilApi
@Composable
fun ItemSavedNews(
    news: NewsModel,
    navController: NavController
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightGrey)
        ) {
            val (image, title) = createRefs()

            Image(
                painter = paintImage(image = news.urlToImage),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(color = RippleWhite),
                        onClick = {
                            navController.putParcelableBundle(key = NEWS_BUNDLE_KEY, value = news)
                            navController.navigate(Screen.DetailScreen.withArgs("ali"))
                        }
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(title) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                RippleGrey
                            )
                        )
                    )
            ) {
                Text(
                    text = news.title,
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 22.sp,
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
            }
        }
    }
}