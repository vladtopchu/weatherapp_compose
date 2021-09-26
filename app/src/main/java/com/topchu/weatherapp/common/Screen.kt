package com.topchu.weatherapp.common

sealed class Screen(val route : String) {
    object MapScreen: Screen("map_screen")
    object WeatherScreen: Screen("weather_screen")
}
