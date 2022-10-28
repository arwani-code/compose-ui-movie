package com.google.myapplication.navigation

enum class ScreenNavigation {
    HomeScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): ScreenNavigation =
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not required")
            }
    }
}