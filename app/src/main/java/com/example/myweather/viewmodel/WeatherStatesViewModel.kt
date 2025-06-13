package com.example.myweather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweather.data.dto.WeatherInfoDto
import com.example.myweather.domain.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.myweather.data.dto.DailyDto
import com.example.myweather.R
import com.example.myweather.data.dto.HourlyDto
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

data class WeatherUiState(
    val weatherInfo: WeatherInfoDto? = null,
)

fun WeatherInfoDto.toWeatherDescription(): String {
    return when (currentWeather.weatherCode) {
        0 -> "Clear sky"
        1, 2, 3 -> "Partly cloudy"
        45, 48 -> "Foggy"
        51, 53, 55 -> "Drizzle"
        61, 63, 65 -> "Rain"
        71, 73, 75 -> "Snow"
        77 -> "Snow grains"
        80, 81, 82 -> "Rain showers"
        85, 86 -> "Snow showers"
        95 -> "Thunderstorm"
        96, 99 -> "Thunderstorm with hail"
        else -> "Unknown"
    }
}

fun WeatherInfoDto.getWeatherIcon(): Int {
    val isDay = currentWeather.isDay == 1
    return when (currentWeather.weatherCode) {
        0 -> if (isDay) R.drawable.clear_sky1 else R.drawable.clear_sky
        1, 2, 3 -> if (isDay) R.drawable.partly_cloudy1 else R.drawable.partly_cloudy
        45, 48 -> R.drawable.fog
        51, 53, 55 -> R.drawable.drizzle_light
        61, 63, 65 -> R.drawable.rain
        71, 73, 75, 77 -> R.drawable.snow_grains
        80, 81, 82 -> R.drawable.rain_shower_slight
        85, 86 -> R.drawable.snow_shower_heavy
        95, 96, 99 -> R.drawable.thunderstrom_slight_or_moderate
        else -> if (isDay) R.drawable.clear_sky1 else R.drawable.clear_sky
    }
}

class WeatherStatesViewModel(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    init {
        getWeatherInfo("53.445345", "34.5435")
    }

    fun getWeatherInfo(latitude: String, longitude: String) {
        viewModelScope.launch {
            val weatherInfo = weatherRepository.getWeatherInfo(latitude, longitude)
            _uiState.update {
                it.copy(
                    weatherInfo = weatherInfo,
                )
            }
        }
    }
}

