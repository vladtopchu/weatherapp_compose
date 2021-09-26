package com.topchu.weatherapp.network

import com.topchu.weatherapp.common.Constants
import com.topchu.weatherapp.network.services.WeatherService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService = retrofit.create(WeatherService::class.java)
}