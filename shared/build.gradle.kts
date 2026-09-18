// Copyright 2025, compose-miuix-ui contributors
// SPDX-License-Identifier: Apache-2.0

plugins {
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

group = "top.yukonga.miuix.kmp"

kotlin {
    jvmToolchain(21)

    android {
        androidResources.enable = true
        compileSdk { version = release(37) { minorApiLevel = 0 } }
        minSdk = 24
        namespace = "top.yukonga.miuix.shared"
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
                implementation(compose.animation)
                implementation(compose.components.resources)

                implementation(libs.miuix.ui)
                implementation(libs.miuix.preference)
                implementation(libs.miuix.blur)
                implementation(libs.miuix.squircle)
                implementation(libs.miuix.icons)
                implementation(libs.miuix.nav)

                implementation(libs.androidx.navigationevent)
                implementation(libs.kotlinx.serialization.core)
            }
        }
    }
}

compose.resources {
    publicResClass = true
}