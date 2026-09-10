package com.example.mybasic.miuixtestnow.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.BasicComponent
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.Switch
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TopAppBar

@Composable
fun MainScreen() {
    var switchState by remember { mutableStateOf(false) }
    var switchState2 by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = "Miuix 组件测试"
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // ====== 卡片示例 ======
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "欢迎使用 Miuix",
                        // fontSize 等样式参数请根据实际 API 调整
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "这是一个基于 Compose Multiplatform 的 HyperOS 风格 UI 库测试项目。"
                    )
                }
            }

            // ====== 基础组件列表 ======
            Text(text = "基础组件")

            BasicComponent(
                title = "设置项 1",
                summary = "这是一个基础组件示例",
                icon = {
                    // 图标槽位
                }
            )

            BasicComponent(
                title = "设置项 2",
                summary = "带有开关的组件",
                action = {
                    Switch(
                        checked = switchState,
                        onCheckedChange = { switchState = it }
                    )
                }
            )

            BasicComponent(
                title = "设置项 3",
                summary = "默认开启的开关",
                action = {
                    Switch(
                        checked = switchState2,
                        onCheckedChange = { switchState2 = it }
                    )
                }
            )

            // ====== 更多组件区域 ======
            Text(text = "更多信息")

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "版本")
                        Text(text = "1.0.0")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "包名")
                        Text(text = "com.example.mybasic.miuixtestnow")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "UI 库")
                        Text(text = "Miuix KMP")
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
