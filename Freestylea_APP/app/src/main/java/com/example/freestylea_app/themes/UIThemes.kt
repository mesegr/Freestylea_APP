package com.example.freestylea_app.themes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Tematica(themeGenerator: ThemeGenerator) {
    var tematica by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        themeGenerator.getRandomTheme { nuevaTematica ->
            tematica = nuevaTematica
        }
    }
    Text(
        text = tematica,
        fontSize = 75.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}