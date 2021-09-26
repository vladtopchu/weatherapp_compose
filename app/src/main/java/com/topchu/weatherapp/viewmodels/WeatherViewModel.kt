package com.topchu.weatherapp.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.topchu.composeweatherapp.data.remote.dto.toWeather
import com.topchu.weatherapp.repository.WeatherRepo
import kotlinx.coroutines.launch
import retrofit2.HttpException

class WeatherViewModel(savedStateHandle: SavedStateHandle, application: Application) : AndroidViewModel(application) {
    private var weatherRepo = WeatherRepo()

    private var _eventNetworkError = MutableLiveData(false)
    private var _isNetworkErrorShown = MutableLiveData(false)
    private var _networkMessage = MutableLiveData("")

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown
    val network: LiveData<String>
        get() = _networkMessage

    val weatherData = weatherRepo.weather.value?.toWeather()

    init {
        savedStateHandle.get<String>("coords")?.let {
            val test = it.split("+")
            getDataFromRepository(test[0], test[1])
        }
    }

    fun getDataFromRepository(lat: String, lon: String) {
        viewModelScope.launch {
            try {
                weatherRepo.getWeather(lat, lon)
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false
            } catch (networkError: HttpException) {
                _networkMessage.value = networkError.localizedMessage
                _eventNetworkError.value = true
            }
        }
    }

    class Factory(val savedStateHandle: SavedStateHandle, val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return WeatherViewModel(savedStateHandle, app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}