package com.google.myapplication.page

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.google.myapplication.LazyColumnShowMovie

@Composable
fun HomeScreen(navController: NavController){
    LazyColumnShowMovie(navController = navController)
}