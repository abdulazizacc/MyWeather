import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

@Composable
fun WeatherScreenAnimation(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (animationPlayed) 1f else 0f,
        animationSpec = tween(1000)
    )
    val slideAnim = animateFloatAsState(
        targetValue = if (animationPlayed) 0f else 100f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        )
    )

    LaunchedEffect(true) {
        animationPlayed = true
    }

    Box(
        modifier = modifier
            .alpha(alphaAnim.value)
            .offset(y = slideAnim.value.dp)
    ) {
        content()
    }
}

@Composable
fun WeatherCardAnimation(
    modifier: Modifier = Modifier,
    delayMillis: Int = 0,
    content: @Composable () -> Unit
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(
        targetValue = if (animationPlayed) 1f else 0f,
        animationSpec = tween(
            durationMillis = 500,
            delayMillis = delayMillis,
            easing = FastOutSlowInEasing
        )
    )

    LaunchedEffect(true) {
        animationPlayed = true
    }

    Box(
        modifier = modifier
            .scale(scale.value)
    ) {
        content()
    }
}