package com.topchu.composeweatherapp.domain.model

import com.topchu.composeweatherapp.data.remote.dto.*

data class Weather(
    val city: String,
    val country: String,
    val main: Main,
    val weather: List<Sky>,
    val wind: Wind
)
