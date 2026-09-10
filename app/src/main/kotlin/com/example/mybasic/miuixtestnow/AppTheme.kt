package com.example.mybasic.miuixtestnow

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import top.yukonga.miuix.kmp.theme.ColorSchemeMode
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.theme.ThemeController

@Composable
fun AppTheme(
    themeState: ThemeState,
    content: @Composable () -> Unit
) {
    if (themeState.useMiuix) {
        MiuixThemeWrapper(themeState, content)
    } else {
        MaterialThemeWrapper(themeState, content)
    }
}

@Composable
private fun MiuixThemeWrapper(
    themeState: ThemeState,
    content: @Composable () -> Unit
) {
    val controller = remember(themeState.dynamicColor, themeState.themeMode) {
        when {
            themeState.dynamicColor -> ThemeController(ColorSchemeMode.MonetSystem)
            themeState.seedColor != null -> ThemeController(
                ColorSchemeMode.System,
                keyColor = themeState.seedColor
            )
            else -> ThemeController(ColorSchemeMode.System)
        }
    }
    MiuixTheme(controller = controller, content = content)
}

@Composable
private fun MaterialThemeWrapper(
    themeState: ThemeState,
    content: @Composable () -> Unit
) {
    val darkTheme = when (themeState.themeMode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }
    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    MaterialTheme(colorScheme = colorScheme, content = content)
}