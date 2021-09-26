package com.topchu.composeweatherapp.presentation.map

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.LatLng

class MapViewModel: ViewModel(){

    private val _state = mutableStateOf(MapState())
    val state : State<MapState> = _state

    init {
        _state.value = MapState()
    }

    fun setCoords(latLng: LatLng) {
        _state.value = MapState(latLng = latLng)
    }
}