package com.example.mybasic.miuixtestnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.miuixthemedemo.data.ThemePreferences
import com.example.miuixthemedemo.data.ThemePreferencesRepository
import com.example.miuixthemedemo.ui.screens.MainScreen
import com.example.miuixthemedemo.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    private lateinit var themePreferences: ThemePreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        themePreferences = ThemePreferencesRepository(applicationContext)

        setContent {
            val themeMode by themePreferences.themeMode.collectAsStateWithLifecycle(
                initialValue = ThemePreferences.ThemeMode.SYSTEM
            )
            val darkMode by themePreferences.darkMode.collectAsStateWithLifecycle(
                initialValue = ThemePreferences.DarkMode.FOLLOW_SYSTEM
            )

            AppTheme(
                themeMode = themeMode,
                darkMode = darkMode
            ) {
                MainScreen(
                    themeMode = themeMode,
                    darkMode = darkMode,
                    onThemeModeChanged = { themePreferences.setThemeMode(it) },
                    onDarkModeChanged = { themePreferences.setDarkMode(it) }
                )
            }
        }
    }
}
