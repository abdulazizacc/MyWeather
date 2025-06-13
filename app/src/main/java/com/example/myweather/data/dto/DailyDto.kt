package com.example.myweather.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DailyDto(
    val time: List<String>,
    val temperatureMax: List<Double>,
    val temperatureMin: List<Double>,
    val weatherCode: List<Int>,
    val uvIndex: List<Double>
)
