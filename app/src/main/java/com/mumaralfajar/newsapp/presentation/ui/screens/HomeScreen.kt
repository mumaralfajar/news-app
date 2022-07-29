package com.mumaralfajar.newsapp.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mumaralfajar.newsapp.R
import com.mumaralfajar.newsapp.presentation.ui.component.*
import com.mumaralfajar.newsapp.presentation.ui.theme.LightGrey
import com.mumaralfajar.newsapp.viewmodel.NewsViewModel

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun HomeScreen(
    navController: NavController,
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val headlineNews by newsViewModel.headlineNewsLiveData.observeAsState(listOf())
    val error by newsViewModel.errorLiveData.observeAsState(false)

    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetUser()
        },
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        sheetBackgroundColor = Color.White
    ) {
        Scaffold {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .background(LightGrey),
            ) {
                ToolbarHome(navController, modalBottomSheetState)

                if (error) {
                    ViewError(tryAgainClick = { newsViewModel.tryAgain() })
                } else {
                    if (headlineNews.isEmpty()) {
                        ShimmerHomeScreen()
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth()
                                .background(LightGrey),
                            contentPadding = PaddingValues(bottom = 20.dp)
                        ) {

                            if (headlineNews.isNotEmpty()) {
                                item {
                                    Pager(
                                        newsList = headlineNews,
                                        navController = navController
                                    )
                                }
                            }

                            if (headlineNews.isNotEmpty()) {
                                item {
                                    ItemHeaderTitle(stringResource(id = R.string.headline_news))
                                }
                                for (i in headlineNews.indices) {
                                    item {
                                        ItemNews(
                                            navController = navController,
                                            news = headlineNews[i]
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}