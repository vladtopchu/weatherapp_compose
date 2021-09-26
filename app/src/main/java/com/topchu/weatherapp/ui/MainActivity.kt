package com.topchu.weatherapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.topchu.composeweatherapp.presentation.map.MapScreen
import com.topchu.composeweatherapp.presentation.weather.WeatherScreen
import com.topchu.weatherapp.common.Screen
import com.topchu.weatherapp.ui.theme.WeatherappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherappTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.MapScreen.route) {
                        composable(Screen.MapScreen.route) { MapScreen(navController) }
                        composable(
                            route = Screen.WeatherScreen.route,
                        ) { WeatherScreen() }
                    }
                }
            }
        }
    }
}