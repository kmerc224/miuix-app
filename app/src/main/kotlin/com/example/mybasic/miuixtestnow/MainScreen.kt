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
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.extended.Contacts
import top.yukonga.miuix.kmp.icon.extended.Settings
import top.yukonga.miuix.kmp.icon.extended.VerticalSplit

@Composable
fun MainScreen(
    themeState: ThemeState,
    onThemeChange: (ThemeState) -> Unit
) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabs = listOf("首页", "超级用户", "模块", "设置")
    val icons = listOf(
        MiuixIcons.VerticalSplit,
        MiuixIcons.Contacts,
        MiuixIcons.Settings,
        MiuixIcons.Settings
    )

    Scaffold(
        topBar = {
            TopAppBar(title = tabs[selectedIndex])
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, label ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = icons[index],
                        label = label
                    )
                }
            }
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