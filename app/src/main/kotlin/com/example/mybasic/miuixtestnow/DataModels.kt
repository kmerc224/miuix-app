package com.example.mybasic.miuixtestnow

data class AppEntry(
    val name: String,
    val packageName: String,
    val tags: List<String> = emptyList()
)

data class ModuleInfo(
    val name: String,
    val version: String,
    val author: String,
    val enabled: Boolean
)