package com.example.myweather.domain

import com.example.myweather.data.dto.WeatherInfoDto

interface WeatherRepository {
    fun getWeatherInfo(latitude: String, longitude: String): WeatherInfoDto
}