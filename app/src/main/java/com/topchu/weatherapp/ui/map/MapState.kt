package com.topchu.composeweatherapp.presentation.map

import com.google.android.gms.maps.model.LatLng

data class MapState(
    val latLng: LatLng? = LatLng(0.0, 0.0)
)
