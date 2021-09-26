package com.topchu.weatherapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.topchu.composeweatherapp.data.remote.dto.WeatherDto
import com.topchu.composeweatherapp.domain.model.Weather
import com.topchu.weatherapp.network.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherRepo {
    private var _weather: MutableLiveData<WeatherDto> = MutableLiveData()

    val weather: LiveData<WeatherDto>
        get() = _weather

    suspend fun getWeather(lat: String, lon: String) {
        withContext(Dispatchers.IO) {
            _weather.postValue(WeatherApi.weatherService.getWeather(lat, lon))
        }
    }
}