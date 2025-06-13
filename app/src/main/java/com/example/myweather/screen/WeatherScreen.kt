package com.example.myweather.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.component.*
import com.example.myweather.composable.*
import com.example.myweather.ui.theme.*
import com.example.myweather.viewmodel.WeatherStatesViewModel
import com.example.myweather.viewmodel.WeatherUiState
import com.example.myweather.viewmodel.getWeatherIcon
import com.example.myweather.viewmodel.toWeatherDescription

import org.koin.androidx.compose.koinViewModel

@Composable
fun WeatherScreen(viewModel: WeatherStatesViewModel = koinViewModel()) {
    val state by viewModel.uiState.collectAsState()
    WeatherContent(state)
}

@Composable
fun WeatherContent(state: WeatherUiState) {
    var colorBrush = Brush.verticalGradient(
        colors = listOf(SkyBlue, White)
    )

    state.weatherInfo?.let { weatherInfo ->
        val isDay = weatherInfo.currentWeather.isDay == 1
        colorBrush = Brush.verticalGradient(
            colors = if (isDay) listOf(SkyBlue, White)
            else listOf(TemperatureColor, BottomNight)
        )

        val listState = rememberLazyListState()

        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(brush = colorBrush),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                LocationRow()
                Spacer(modifier = Modifier.height(12.dp))
                CurrentWeatherIcon(image = weatherInfo.getWeatherIcon())
            }
            item {
                CurrentTemperature(
                    temperature = "${weatherInfo.currentWeather.temperature.toInt()}°C",
                    description = weatherInfo.toWeatherDescription(),
                    maxTemperature = weatherInfo.daily.temperatureMax.first().toInt().toString(),
                    minTemperature = weatherInfo.daily.temperatureMin.first().toInt().toString()
                )
            }
            item {
                WeatherStatusContent(
                    windValue = "${weatherInfo.currentWeather.windSpeed} km/h",
                    humidityValue = "${weatherInfo.currentWeather.relativeHumidity}%",
                    rainValue = "${weatherInfo.currentWeather.precipitationProbability}%",
                    pressureValue = "${weatherInfo.currentWeather.surfacePressure.toInt()} hPa",
                    uvValue = "${weatherInfo.daily.uvIndex.first().toInt()}",
                    feelsLikeValue = "${weatherInfo.currentWeather.apparentTemperature.toInt()}°C"
                )
            }
            item {
                Column() {
                    Text(
                        text = "Today",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = urbanistFamily,
                            color = TemperatureColor
                        ),
                        modifier = Modifier
                            .padding(vertical = 24.dp, horizontal = 12.dp)
                    )

                    LazyRow(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 16.dp)
                    ) {
                        items(weatherInfo.hourly.time.size) { index ->
                            val icon = weatherInfo.getWeatherIcon()
                            val temp = "${weatherInfo.hourly.temperature[index].toInt()}°C"
                            val time = weatherInfo.hourly.time[index].substringAfter("T")
                            TodayCard(
                                image = icon,
                                temperature = temp,
                                time = time
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                        }
                    }
                }
            }

            item {
                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                    Text(
                        "Next 7 Days", modifier = Modifier.padding(bottom = 12.dp),
                        fontSize = 20.sp,
                        fontFamily = urbanistFamily,
                        color = LocationColor,
                        letterSpacing = 0.25.sp,
                        fontWeight = FontWeight(600)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(24.dp))
                            .border(
                                1.dp,
                                BorderColor,
                                shape = RoundedCornerShape(24.dp)
                            )
                            .background(White)
                    ) {
                        weatherInfo.daily.time.forEachIndexed { index, dayName ->
                            NextDaysCard(
                                dayName = dayName,
                                maxTemperature = weatherInfo.daily.temperatureMax[index],
                                minTemperature = weatherInfo.daily.temperatureMin[index],
                                image = weatherInfo.getWeatherIcon(),
                            )

                            if (index != weatherInfo.daily.time.size - 1) {
                                HorizontalDivider(
                                    thickness = 1.dp,
                                    color = BorderColor
                                )
                            }
                        }
                    }
                }

            }


        }
    }

}