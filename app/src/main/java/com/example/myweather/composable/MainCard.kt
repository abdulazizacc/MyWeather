package com.example.myweather.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.SubTemperatureColor
import com.example.myweather.ui.theme.urbanistFamily

@Preview(showBackground = true)
@Composable
fun SmallTemperatureCard(maxTemperature: String = "24", minTemperature: String = "18") {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(Color(0x14060414), RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.small_arrow_up),
                contentDescription = null,
                tint = SubTemperatureColor,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = "$maxTemperature°C",
                fontSize = 16.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(500),
                color = SubTemperatureColor,
            )
            Icon(
                painter = painterResource(R.drawable.line_1),
                contentDescription = null,
                tint = Color(0x3D060414),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Icon(
                painter = painterResource(R.drawable.small_arrow_down),
                contentDescription = null,
                tint = SubTemperatureColor,
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = "$minTemperature°C",
                fontSize = 16.sp,
                fontFamily = urbanistFamily,
                fontWeight = FontWeight(500),
                color = SubTemperatureColor,
            )

        }
    }
}