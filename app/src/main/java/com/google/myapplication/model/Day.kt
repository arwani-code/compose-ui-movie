package com.google.myapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    val id: Int,
    @StringRes val dayTitleRes: Int,
    @StringRes val dayBodyRes: Int,
    @DrawableRes val dayImageRes: Int
)
