package com.example.postapp2.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4CAF50),      // Verde principal
    secondary = Color(0xFF81C784),     // Verde secundário
    tertiary = Color(0xFFA5D6A7),      // Verde terciário
    background = Color(0xFF121212),    // Fundo escuro
    surface = Color(0xFF1E1E1E)        // Superfície escura
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2E7D32),      // Verde principal mais escuro
    secondary = Color(0xFF4CAF50),     // Verde secundário
    tertiary = Color(0xFF81C784),      // Verde terciário
    background = Color(0xFFFAFAFA),    // Fundo claro
    surface = Color(0xFFFFFFFF)        // Superfície clara
)

@Composable
fun PostApp2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}