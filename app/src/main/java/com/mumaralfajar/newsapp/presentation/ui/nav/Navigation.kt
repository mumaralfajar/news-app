package com.mumaralfajar.newsapp.presentation.ui.nav

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.mumaralfajar.newsapp.model.NewsModel
import com.mumaralfajar.newsapp.presentation.ui.screens.DetailScreen
import com.mumaralfajar.newsapp.presentation.ui.screens.HomeScreen
import com.mumaralfajar.newsapp.presentation.ui.screens.SavedScreen
import com.mumaralfajar.newsapp.presentation.ui.screens.Screen
import com.mumaralfajar.newsapp.utils.constants.Constants
import com.mumaralfajar.newsapp.utils.extentions.getParcelableBundle

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalCoilApi
@ExperimentalComposeUiApi
@ExperimentalPagerApi
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        // home screen
        composable(
            route = Screen.HomeScreen.route,
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            }
        ) {
            HomeScreen(
                navController = navController
            )
        }

        // saved screen
        composable(
            route = Screen.SavedScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Umar"
                    nullable = true
                }
            ),
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            },
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            }
        ) { entry ->
            SavedScreen(
                navController = navController,
                name = entry.arguments?.getString("name")
            )
        }

        // detail screen
        composable(
            route = Screen.DetailScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Umar"
                    nullable = true
                }
            ),
            enterTransition = { _, _ ->
                slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))
            },
            popExitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))
            }
        ) { entry ->
            DetailScreen(
                navController = navController,
                name = entry.arguments?.getString("name"),
                news = navController.getParcelableBundle(Constants.NEWS_BUNDLE_KEY) as NewsModel?
            )
        }
    }
}