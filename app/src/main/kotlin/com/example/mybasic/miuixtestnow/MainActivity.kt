package com.example.mybasic.miuixtestnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var themeState by rememberSaveable { mutableStateOf(ThemeState()) }

            AppTheme(themeState = themeState) {
                MainScreen(
                    themeState = themeState,
                    onThemeChange = { themeState = it }
                )
            }
        }
    }
}