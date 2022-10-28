package com.google.myapplication.page

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.myapplication.model.Movie

@Composable
fun DetailScreen(navController: NavController, movie: Movie?) {
    Scaffold(topBar = { MovieTopBar(navController = navController) }) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (movie != null) {
                Text(text = movie.title, style = MaterialTheme.typography.h3)
            }
        }
    }
}


@Composable
fun MovieTopBar(modifier: Modifier = Modifier, navController: NavController) {
    TopAppBar(title = {
        Text(
            text = "Detail",
        )
    }, navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(Icons.Filled.ArrowBack, null)
        }
    }, backgroundColor = MaterialTheme.colors.secondary)
}