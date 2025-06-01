package com.example.beautyandfashion.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = BrownDark,
    onPrimary = White,
    secondary = BrownMedium,
    onSecondary = White,
    background = CreamLight,
    onBackground = Black,
    surface = Cream,
    onSurface = BrownDark,
)

@Composable
fun BeautyAndFashionTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
