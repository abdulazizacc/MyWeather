package com.example.myweather.data

import com.example.myweather.data.dto.CurrentWeatherDto
import com.example.myweather.data.dto.DailyDto
import com.example.myweather.data.dto.HourlyDto
import com.example.myweather.data.dto.WeatherInfoDto
import com.example.myweather.domain.WeatherRepository

class WeatherRepositoryImpl : WeatherRepository {
    override fun getWeatherInfo(latitude: String, longitude: String): WeatherInfoDto {
        return WeatherInfoDto(
            currentWeather = CurrentWeatherDto(
                time = "2024-03-20T12:00:00",
                interval = 900,
                weatherCode = 1,
                relativeHumidity = 65,
                windSpeed = 12.5,
                precipitationProbability = 20,
                surfacePressure = 1013.2,
                apparentTemperature = 22.5,
                temperature = 24.0,
                isDay = 1
            ),
            daily = DailyDto(
                time = listOf(
                    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
                ),
                temperatureMax = listOf(26.0, 27.0, 25.0, 28.0, 26.0, 27.0, 25.0),
                temperatureMin = listOf(18.0, 19.0, 17.0, 20.0, 18.0, 19.0, 17.0),
                weatherCode = listOf(1, 2, 3, 1, 2, 3, 1),
                uvIndex = listOf(5.0, 6.0, 4.0, 7.0, 5.0, 6.0, 4.0)
            ),
            hourly = HourlyDto(
                time = listOf(
                    "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00",
                    "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00",
                    "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"
                ),
                temperature = listOf(
                    20.0, 19.0, 18.0, 18.0, 17.0, 17.0, 18.0, 20.0, 22.0, 24.0, 25.0, 26.0,
                    27.0, 26.0, 25.0, 24.0, 23.0, 22.0, 21.0, 20.0, 19.0, 18.0, 17.0, 17.0
                ),
                weatherCode = listOf(
                    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                    2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2
                ),
                isDay = listOf(
                    0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,
                    1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0
                )
            )
        )
    }
}