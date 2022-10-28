package com.google.myapplication.data

import androidx.compose.ui.res.stringResource
import com.google.myapplication.R
import com.google.myapplication.model.Day

object DaysRepository {
    val days = listOf<Day>(
        Day(
            id = 1,
            dayTitleRes = R.string.dayTitle1,
            dayBodyRes = R.string.dayBody1,
            dayImageRes = R.drawable.img_day1
        ),
        Day(
            id = 2,
            dayTitleRes = R.string.dayTitle2,
            dayBodyRes = R.string.dayBody2,
            dayImageRes = R.drawable.img_day2
        ),
        Day(
            id = 3,
            dayTitleRes = R.string.dayTitle3,
            dayBodyRes = R.string.dayBody3,
            dayImageRes = R.drawable.img_day3
        ),
        Day(
            id = 4,
            dayTitleRes = R.string.dayTitle4,
            dayBodyRes = R.string.dayBody4,
            dayImageRes = R.drawable.img_day4
        ),
        Day(
            id = 5,
            dayTitleRes = R.string.dayTitle5,
            dayBodyRes = R.string.dayBody5,
            dayImageRes = R.drawable.img_day5
        ),
        Day(
            id = 6,
            dayTitleRes = R.string.dayTitle6,
            dayBodyRes = R.string.dayBody6,
            dayImageRes = R.drawable.img_day6
        ),
        Day(
            id = 7,
            dayTitleRes = R.string.dayTitle7,
            dayBodyRes = R.string.dayBody7,
            dayImageRes = R.drawable.img_day7
        ),
        Day(
            id = 8,
            dayTitleRes = R.string.dayTitle8,
            dayBodyRes = R.string.dayBody8,
            dayImageRes = R.drawable.img_day8
        ),
        Day(
            id = 9,
            dayTitleRes = R.string.dayTitle9,
            dayBodyRes = R.string.dayBody9,
            dayImageRes = R.drawable.img_day9
        ),
        Day(
            id = 10,
            dayTitleRes = R.string.dayTitle10,
            dayBodyRes = R.string.dayBody10,
            dayImageRes = R.drawable.img_day10
        ),
    )
}