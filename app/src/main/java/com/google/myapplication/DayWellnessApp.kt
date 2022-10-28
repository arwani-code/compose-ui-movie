package com.google.myapplication

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.myapplication.data.DaysRepository
import com.google.myapplication.model.Day

@Composable
fun DayWellnessApp() {

    Scaffold(topBar = { TopAppBar(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp), title = { Text(
        text = "Top App Bar"
    )}, backgroundColor = MaterialTheme.colors.primary, elevation = 2.dp) }) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(DaysRepository.days) { day ->
                DayItemCard(day = day)
            }
        }
    }
}

@Composable
fun DayItemCard(modifier: Modifier = Modifier, day: Day) {
    val expanded = remember {
        mutableStateOf(false)
    }
    Card(
        elevation = 2.dp, modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        DayContent(day = day, expanded = expanded)
    }
}

@Composable
fun DayContent(modifier: Modifier = Modifier, day: Day, expanded: MutableState<Boolean>) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Text(
            modifier = modifier.padding(top = 5.dp, bottom = 15.dp),
            text = stringResource(R.string.dayNumber, day.id),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.secondary
        )
        Text(
            text = stringResource(day.dayTitleRes),
            color = MaterialTheme.colors.onSecondary,
            modifier = modifier.padding(bottom = 8.dp)
        )
        Image(
            painter = painterResource(id = day.dayImageRes), contentDescription = stringResource(
                id = day.dayTitleRes
            ), contentScale = ContentScale.Crop, modifier = modifier
                .fillMaxWidth()
                .clickable { expanded.value = !expanded.value }
        )
        if (expanded.value) {
            DayBody(day = day)
        }
    }
}

@Composable
fun DayBody(modifier: Modifier = Modifier, day: Day) {
    Text(
        text = stringResource(day.dayBodyRes),
        color = MaterialTheme.colors.onSecondary,
        modifier = modifier.padding(bottom = 4.dp)
    )
}

@Composable
fun DayTopBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.topBarDays),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primary
        )
    }
}