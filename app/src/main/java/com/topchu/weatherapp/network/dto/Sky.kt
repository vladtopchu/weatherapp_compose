package com.topchu.composeweatherapp.data.remote.dto

data class Sky(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)