package com.example.mybasic.miuixtestnow

import androidx.compose.ui.graphics.Color

data class ThemeState(
    val useMiuix: Boolean = true,
    val themeMode: ThemeMode = ThemeMode.SYSTEM,
    val seedColor: Color? = null,
    val dynamicColor: Boolean = true
)

enum class ThemeMode { LIGHT, DARK, SYSTEM }