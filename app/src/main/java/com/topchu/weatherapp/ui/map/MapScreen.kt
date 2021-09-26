package com.topchu.composeweatherapp.presentation.map

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.topchu.weatherapp.common.Screen
import com.topchu.weatherapp.ui.components.Map

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapViewModel = viewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Map(
            onClick = { viewModel.setCoords(it) },
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        Column(modifier = Modifier.padding(10.dp)) {
            Text("Choosed coordinates:")
            Text(text = "${state.latLng?.latitude} / ${state.latLng?.longitude}")
            Button(
                modifier = Modifier.fillMaxWidth().height(40.dp),
                onClick = {
                    val test = "${state.latLng?.latitude}+${state.latLng?.longitude}"
                    navController.navigate(Screen.WeatherScreen.route)
                }) {
                Text("Click")
            }
        }
    }
}