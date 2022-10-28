package com.google.myapplication

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.myapplication.data.DaysRepository
import com.google.myapplication.model.Day
import com.google.myapplication.navigation.ScreenNavigation

@Composable
fun LazyColumnShowMovie(navController: NavController) {
    Scaffold(topBar = { TopBar() }) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.onBackground)) {
            items(DaysRepository.days) { day ->
                MovieItem(navController = navController, day = day, onClick = {
                    navController.navigate(route = ScreenNavigation.DetailScreen.name)
                })
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
fun MovieItem(navController: NavController,modifier: Modifier = Modifier, onClick: (Int) -> Unit,day: Day) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(154.dp)
            .padding(8.dp)
            .clickable { onClick(day.dayTitleRes) },
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
                Image(
                    modifier = Modifier.padding(10.dp),
                    painter = painterResource(id = R.drawable.img_day1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Text(text = stringResource(id = day.dayTitleRes), style = MaterialTheme.typography.body1)
        }
    }
}