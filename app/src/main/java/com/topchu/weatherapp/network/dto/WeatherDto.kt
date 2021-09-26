package com.topchu.composeweatherapp.data.remote.dto
import com.topchu.composeweatherapp.domain.model.Weather

data class WeatherDto(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Sky>,
    val wind: Wind
)

fun WeatherDto.toWeather() : Weather{
    return Weather(
        city = name,
        country = sys.country,
        main = main,
        weather = weather,
        wind = wind
    )
}