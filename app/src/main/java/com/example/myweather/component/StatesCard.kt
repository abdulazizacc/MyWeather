package com.example.myweather.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myweather.R
import com.example.myweather.composable.InformationCard


@Composable
fun WeatherStatusContent(
    windValue: String,
    humidityValue: String,
    rainValue: String,
    pressureValue: String,
    uvValue: String,
    feelsLikeValue: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(horizontal = 12.dp)
            .padding(top = 24.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            InformationCard(
                image = (R.drawable.fast_wind),
                measurement = windValue,
                information = "Wind",
                modifier = Modifier.weight(1f)
            )
            InformationCard(
                image = (R.drawable.humidity),
                measurement = humidityValue,
                information = "Humidity",
                modifier = Modifier.weight(1f)
            )
            InformationCard(
                image = (R.drawable.rain),
                measurement = rainValue,
                information = "Rain",
                modifier = Modifier.weight(1f)
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {

            InformationCard(
                image = (R.drawable.ultraviolet),
                measurement = uvValue,
                information = "UV Index",
                modifier = Modifier.weight(1f)

            )
            InformationCard(
                image = (R.drawable.arrow_down),
                measurement = pressureValue,
                information = "Pressure",
                modifier = Modifier.weight(1f)

            )
            InformationCard(
                image = (R.drawable.temperature),
                measurement = feelsLikeValue,
                information = "Feels Like",
                modifier = Modifier.weight(1f)
            )
        }
    }
}