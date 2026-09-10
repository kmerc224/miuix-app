package com.example.mybasic.miuixtestnow

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.Switch
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun ModuleScreen() {
    val mockModules = remember {
        listOf(
            ModuleInfo("LSPosed", "v1.9.2", "LSPosed Developers", true),
            ModuleInfo("Shamiko", "v1.2.1", "LSPosed", true),
            ModuleInfo("Zygisk-Next", "v4.0", "Dr-TSNG", false),
        )
    }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(mockModules) { module ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(module.name, style = MiuixTheme.textStyles.title3)
                        Text(
                            "${module.version} · ${module.author}",
                            style = MiuixTheme.textStyles.footnote1,
                            color = MiuixTheme.colorScheme.onSurfaceVariantSummary
                        )
                    }
                    Switch(
                        checked = module.enabled,
                        onCheckedChange = { /* 切换 */ }
                    )
                }
            }
        }
    }
}