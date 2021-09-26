package com.topchu.weatherapp.network.services

import com.topchu.composeweatherapp.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/data/2.5/weather?appid=eb0c88bddc429cc23014d495b8e3d86c")
    suspend fun getWeather(@Query("lat") lat : String, @Query("lon") lon : String) : WeatherDto
}