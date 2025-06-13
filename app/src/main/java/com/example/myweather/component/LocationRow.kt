package com.example.myweather.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.LocationColor
import com.example.myweather.ui.theme.urbanistFamily

@Composable
fun LocationRow(){
    Row(
        modifier = Modifier
            .padding(top = 64.dp, start = 133.dp, end = 133.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.city_location),
            contentDescription = null,
            tint = LocationColor
        )
        Text(
            text = "Baghdad",
            fontSize = 16.sp,
            fontFamily = urbanistFamily,
            fontWeight = FontWeight(500),
            color = LocationColor
        )
    }
}