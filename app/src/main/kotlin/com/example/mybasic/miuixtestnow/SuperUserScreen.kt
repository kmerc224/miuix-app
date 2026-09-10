package com.example.mybasic.miuixtestnow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.Card
import top.yukonga.miuix.kmp.basic.CardDefaults
import top.yukonga.miuix.kmp.basic.TextField
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun SuperUserScreen() {
    var searchText by remember { mutableStateOf("") }
    val mockApps = remember {
        listOf(
            AppEntry("微信", "com.tencent.mm", listOf("ROOT")),
            AppEntry("支付宝", "com.eg.android.AlipayGphone", listOf()),
            AppEntry("设置", "com.android.settings", listOf("ROOT", "CUSTOM")),
        )
    }

    Column(Modifier.fillMaxSize()) {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = "搜索应用...",
            useLabelAsPlaceholder = true,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(mockApps.filter {
                it.name.contains(searchText, ignoreCase = true)
            }) { app ->
                AppListItem(app)
            }
        }
    }
}

@Composable
fun AppListItem(app: AppEntry) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.size(44.dp)
                    .background(MiuixTheme.colorScheme.surfaceVariant, RoundedCornerShape(12.dp))
            )
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(app.name, style = MiuixTheme.textStyles.body1)
                Text(
                    app.packageName,
                    style = MiuixTheme.textStyles.footnote1,
                    color = MiuixTheme.colorScheme.onSurfaceVariantSummary
                )
            }
            app.tags.forEach { tag ->
                StatusChip(tag)
            }
        }
    }
}

@Composable
fun StatusChip(tag: String) {
    Card(
        modifier = Modifier.padding(start = 4.dp),
        colors = CardDefaults.defaultColors(
            color = if (tag == "ROOT") MiuixTheme.colorScheme.primaryContainer
            else MiuixTheme.colorScheme.secondaryContainer
        )
    ) {
        Text(
            tag,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            style = MiuixTheme.textStyles.footnote1,
            color = MiuixTheme.colorScheme.onPrimaryContainer
        )
    }
}