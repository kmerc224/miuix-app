package com.example.miuixdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import top.yukonga.miuix.kmp.basic.*
import top.yukonga.miuix.kmp.extra.MiuixIcons
import top.yukonga.miuix.kmp.theme.MiuixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiuixTheme {
                var selectedIndex by remember { mutableIntStateOf(0) }
                val navItems = listOf("首页", "设置")
                val navIcons = listOf(MiuixIcons.VerticalSplit, MiuixIcons.Settings)

                Scaffold(
                    topBar = {
                        SmallTopAppBar(title = "Miuix 示例")
                    },
                    bottomBar = {
                        NavigationBar {
                            navItems.forEachIndexed { index, label ->
                                NavigationBarItem(
                                    selected = selectedIndex == index,
                                    onClick = { selectedIndex = index },
                                    icon = { Icon(navIcons[index], contentDescription = label) },
                                    label = label
                                )
                            }
                        }
                    }
                ) { paddingValues ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        when (selectedIndex) {
                            0 -> Text(
                                text = "欢迎使用 Miuix！",
                                modifier = Modifier.padding(26.dp)
                            )
                            1 -> Text(
                                text = "设置页面",
                                modifier = Modifier.padding(26.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}