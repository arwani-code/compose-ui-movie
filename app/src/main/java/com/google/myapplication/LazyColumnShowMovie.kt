package com.google.myapplication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import coil.size.Size
import com.google.myapplication.data.MovieRepository
import com.google.myapplication.model.Movie
import com.google.myapplication.navigation.ScreenNavigation

@Composable
fun LazyColumnShowMovie(navController: NavController) {
    Scaffold(topBar = { TopBar() }) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.onBackground)) {
            items(MovieRepository.getMovies()) { movie ->
                val titleRes = movie.id
                MovieItem(navController = navController, onClick = {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "movie",
                        value = it
                    )
                    navController.navigate(route = ScreenNavigation.DetailScreen.name+"/$titleRes")
                }, movie = movie)
            }
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .background(color = MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Movie App", style = MaterialTheme.typography.h3)
    }
}

@Composable
fun MovieItem(navController: NavController,modifier: Modifier = Modifier, onClick: (Movie) -> Unit, movie: Movie) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(154.dp)
            .padding(8.dp)
            .clickable { onClick(movie) },
        elevation = 3.dp,
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.poster)
                        .size(Size.ORIGINAL) // Set the target size to load the image at.
                        .build(),
                    contentDescription = movie.title
                ) {
                    val state = painter.state
                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        CircularProgressIndicator()
                    } else {
                        SubcomposeAsyncImageContent()
                    }
                }

            }
            Text(text = movie.title, style = MaterialTheme.typography.body1)
        }
    }
}