package com.google.myapplication.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.myapplication.data.MovieRepository
import com.google.myapplication.model.Movie
import com.google.myapplication.page.DetailScreen
import com.google.myapplication.page.HomeScreen


@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenNavigation.HomeScreen.name) {
        composable(ScreenNavigation.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(
            ScreenNavigation.DetailScreen.name + "/{movie}"
        ) {
            val movie =
                navController.previousBackStackEntry?.savedStateHandle?.get<Movie>(
                    "movie"
                )
            Log.i("movieApppp", movie.toString())
            DetailScreen(navController = navController, movie)
        }
    }
}