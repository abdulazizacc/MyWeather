package com.example.myweather.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.BorderColor
import com.example.myweather.ui.theme.White
import com.example.myweather.ui.theme.urbanistFamily
import com.example.myweather.ui.theme.SubTemperatureColor

@Composable
fun NextDaysCard(
    dayName: String,
    image: Int,
    maxTemperature: Double,
    minTemperature: Double,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .height(61.dp)
            .fillMaxWidth(),
    ) {
        Text(
            dayName,
            Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterStart),
            fontSize = 16.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(400),
            letterSpacing = 0.25.sp,
            color = Color(0x99060414)
        )
        Row(modifier  = Modifier.align(Alignment.Center),) {
            Image(
                painter = painterResource(id = image)
                , contentDescription = null,modifier = Modifier.height(32.dp))
        }

        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .padding(vertical = 21.dp, horizontal = 16.dp)
                .align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)

        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.small_arrow_up),
                    contentDescription = null,
                    modifier = Modifier
                        .size(12.dp)
                        .offset(y = 3.dp)
                )
                Text(
                    text = "$maxTemperature °C",
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center,
                    color = Color(0xDE060414)
                )
            }
            VerticalDivider(
                thickness = 1.dp,
                color = Color(0x3D060414),
                modifier = Modifier.padding(horizontal = 4.dp)
            )
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.small_arrow_down),
                    contentDescription = null,
                    tint = Color.Unspecified ,
                    modifier = Modifier
                        .size(12.dp)
                        .offset(y = 3.dp)
                )
                Text(
                    text = "$minTemperature °C",
                    fontSize = 14.sp,
                    letterSpacing = 0.25.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(500),
                    textAlign = TextAlign.Center,
                    color = Color(0xDE060414)
                )
            }
        }
    }
}