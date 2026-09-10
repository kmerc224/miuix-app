package com.example.mybasic.miuixtestnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mybasic.miuixtestnow.theme.MiuixTestAppTheme
import com.example.mybasic.miuixtestnow.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiuixTestAppTheme {
                MainScreen()
            }
        }
    }
}
