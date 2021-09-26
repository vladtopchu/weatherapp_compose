package com.topchu.composeweatherapp.presentation.weather

import com.topchu.composeweatherapp.domain.model.Weather

data class WeatherState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String = ""
)
