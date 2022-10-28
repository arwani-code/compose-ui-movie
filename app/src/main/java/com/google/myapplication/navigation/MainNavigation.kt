package com.google.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.myapplication.page.DetailScreen
import com.google.myapplication.page.HomeScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenNavigation.HomeScreen.name) {
        composable(ScreenNavigation.HomeScreen.name){
            HomeScreen(navController = navController)
        }
        composable(ScreenNavigation.DetailScreen.name){
            DetailScreen(navController = navController)
        }
    }
}