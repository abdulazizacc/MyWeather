package com.example.myweather.composable

import android.R.attr.letterSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweather.R
import com.example.myweather.ui.theme.SkyBlue
import com.example.myweather.ui.theme.SubTemperatureColor
import com.example.myweather.ui.theme.TemperatureCardColor
import com.example.myweather.ui.theme.White
import com.example.myweather.ui.theme.urbanistFamily

@Composable
fun InformationCard(
    image: Int,
    measurement : String,
    information: String,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .background(White, RoundedCornerShape(16.dp))
            .border(1.dp, Color(0x14060414), RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(id = image),
                contentDescription = null,
                tint = SkyBlue,
                modifier = Modifier.padding(bottom = 8.dp, )
            )
            Column(
                modifier = Modifier.padding(horizontal = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = measurement,
                    fontSize = 20.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(500),
                    color = TemperatureCardColor,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.padding(bottom = 2.dp),
                )
                Text(
                    text = information,
                    fontSize = 14.sp,
                    fontFamily = urbanistFamily,
                    fontWeight = FontWeight(400),
                    letterSpacing = 0.25.sp,
                    color = SubTemperatureColor,
                )
            }
        }
    }
}