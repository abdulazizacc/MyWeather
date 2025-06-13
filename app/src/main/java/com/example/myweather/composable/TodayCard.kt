package com.example.myweather.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.ui.theme.SubTemperatureColor
import com.example.myweather.ui.theme.TemperatureCardColor
import com.example.myweather.ui.theme.White
import com.example.myweather.ui.theme.urbanistFamily

@Composable
fun TodayCard(
    image: Int,
    temperature: String,
    time: String,
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(White, RoundedCornerShape(16.dp))
            .border(1.dp, Color(0x14060414), RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(height = 58.dp, width = 64.dp),
            ) {
                Icon(
                    painter = painterResource(image),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = (-30).dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                Text(
                    text = temperature,
                    fontSize = 16.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(500),
                    color = TemperatureCardColor,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.padding(bottom = 4.dp),
                )
                Text(
                    text = time,
                    fontSize = 16.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(500),
                    color = SubTemperatureColor,
                )
            }
        }
    }
}