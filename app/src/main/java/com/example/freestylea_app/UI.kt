package com.example.freestylea_app

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Palabra() {
    var palabra by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        WordGenerator().startWordStream { nuevaPalabra ->
            palabra = nuevaPalabra
        }
    }

    Box(
        modifier = Modifier
            .fillMaxHeight()
    )
    Text(
        text = palabra,
        fontSize = 52.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier
            .offset(y = 350.dp)
    )
}