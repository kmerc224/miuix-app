package com.example.mybasic.miuixtestnow

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.SmallTitle
import top.yukonga.miuix.kmp.preference.SwitchPreference

@Composable
fun SettingsScreen(
    themeState: ThemeState,
    onThemeChange: (ThemeState) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SmallTitle(text = "外观")
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    SwitchPreference(
                        title = "使用 MIUIx 主题",
                        summary = if (themeState.useMiuix) "当前为 MIUIx 风格"
                        else "当前为 Material 3 风格",
                        checked = themeState.useMiuix,
                        onCheckedChange = {
                            onThemeChange(themeState.copy(useMiuix = it))
                        }
                    )
                    HorizontalDivider()
                    SwitchPreference(
                        title = "动态取色",
                        summary = "跟随壁纸自动生成配色",
                        checked = themeState.dynamicColor,
                        onCheckedChange = {
                            onThemeChange(themeState.copy(dynamicColor = it))
                        }
                    )
                }
            }
        }

        item {
            SmallTitle(text = "关于")
            Card(modifier = Modifier.fillMaxWidth()) {
                Column {
                    InfoRow("版本", "1.0.0")
                    HorizontalDivider()
                    InfoRow("开源许可", "Apache 2.0")
                }
            }
        }
    }
}