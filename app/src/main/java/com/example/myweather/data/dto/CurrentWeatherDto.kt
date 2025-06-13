package com.example.myweather.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    val time: String,
    val interval: Int,
    val weatherCode: Int,
    val relativeHumidity: Int,
    val windSpeed: Double,
    val precipitationProbability: Int,
    val surfacePressure: Double,
    val apparentTemperature: Double,
    val temperature: Double,
    val isDay: Int,
)
