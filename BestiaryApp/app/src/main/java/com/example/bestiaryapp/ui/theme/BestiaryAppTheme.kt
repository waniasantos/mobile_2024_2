package com.example.bestiaryapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkRed = Color(0xFF8B0000)
private val Black = Color(0xFF000000)
private val LightBackground = Color(0xFFFFFFFF)
private val TextColor = Color(0xFF4A4A4A)
private val DarkRedselectedIcon = Color(0x188B0000)


private val BestiaryColorScheme = lightColorScheme(
    primary = DarkRed,
    onPrimary = Color.White,
    secondary = Color(0xFFD32F2F),
    onSecondary = Color.White,
    background = LightBackground,
    onBackground = TextColor,
    surface = Color.White,
    onSurface = TextColor,
    surfaceVariant = Color(0xFFEDEDED),
    onSurfaceVariant = Color(0xFF757575),
    inversePrimary = DarkRedselectedIcon,
)

@Composable
fun BestiaryAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = BestiaryColorScheme,
        content = content
    )
}
