package com.example.myweather.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myweather.R


@Composable
fun CurrentWeatherIcon(image: Int) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.background_shadows),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(height = 200.dp, width = 220.21.dp)
        )
        Icon(
            painter = painterResource(id = image),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .size(height = 200.dp, width = 220.21.dp)

        )

    }
}