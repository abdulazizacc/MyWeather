package com.example.myweather.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.composable.SmallTemperatureCard
import com.example.myweather.ui.theme.SubTemperatureColor
import com.example.myweather.ui.theme.TemperatureColor
import com.example.myweather.ui.theme.urbanistFamily

@Composable
fun CurrentTemperature(
    temperature: String,
    description: String,
    maxTemperature: String,
    minTemperature: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = temperature,
            fontSize = 64.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight.SemiBold,
            color = TemperatureColor
        )
        Text(
            text = description,
            fontSize = 16.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(500),
            color = SubTemperatureColor,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )

        SmallTemperatureCard(
            maxTemperature = maxTemperature,
            minTemperature = minTemperature
        )
    }
}