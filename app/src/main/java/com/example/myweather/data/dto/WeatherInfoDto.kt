package com.example.myweather.data.dto

data class WeatherInfoDto(
    val currentWeather: CurrentWeatherDto,
    val daily: DailyDto,
    val hourly: HourlyDto
)
