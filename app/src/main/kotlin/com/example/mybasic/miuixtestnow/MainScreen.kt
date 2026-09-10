package com.example.mybasic.miuixtestnow

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import top.yukonga.miuix.kmp.basic.NavigationBar
import top.yukonga.miuix.kmp.basic.NavigationBarItem
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.icons.MiuixIcons
import top.yukonga.miuix.kmp.icons.filled.Account
import top.yukonga.miuix.kmp.icons.filled.Extensions
import top.yukonga.miuix.kmp.icons.filled.Home
import top.yukonga.miuix.kmp.icons.filled.Settings

@Composable
fun MainScreen(
    themeState: ThemeState,
    onThemeChange: (ThemeState) -> Unit
) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabs = listOf("首页", "超级用户", "模块", "设置")
    val icons = listOf(
        MiuixIcons.Home,
        MiuixIcons.Account,
        MiuixIcons.Extensions,
        MiuixIcons.Settings
    )

    Scaffold(
        topBar = { TopAppBar(title = tabs[selectedIndex]) },
        bottomBar = {
            NavigationBar(
                items = tabs.zip(icons).map { (label, icon) ->
                    NavigationBarItem(icon = icon, label = label)
                },
                selectedIndex = selectedIndex,
                onSelectedIndexChange = { selectedIndex = it }
            )
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when (selectedIndex) {
                0 -> HomeScreen()
                1 -> SuperUserScreen()
                2 -> ModuleScreen()
                3 -> SettingsScreen(themeState, onThemeChange)
            }
        }
    }
}