package com.example.myweather.data.dto

import kotlinx.serialization.SerialName

data class HourlyDto(
    val time: List<String>,
    val temperature: List<Double>,
    val weatherCode: List<Int>,
    val isDay: List<Int>
)
