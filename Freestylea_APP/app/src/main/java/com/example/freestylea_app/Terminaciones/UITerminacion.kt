package com.example.freestylea_app.Terminaciones

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freestylea_app.R

@Composable
fun Terminacion(themeGenerator: terminacionGenerator, onBack: () -> Unit) {
    var tematica by remember { mutableStateOf("") }

    fun actualizarTematica() {
        themeGenerator.getRandomTerminacion { nuevaTematica -> tematica = nuevaTematica }
    }

    LaunchedEffect(Unit) { actualizarTematica() }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        val pagePadding = (maxWidth.value * 0.04f).coerceIn(12f, 24f).dp
        val actionTextSize = (maxWidth.value * 0.055f).coerceIn(16f, 26f).sp
        val themeTextSize = (maxWidth.value * 0.18f).coerceIn(38f, 76f).sp
        val gradient = Brush.horizontalGradient(
            colors = listOf(Color(0xFFFF00AA), Color(0xFF0037FF), Color(0xFF4CC9FF))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(pagePadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .padding(4.dp)
                        .background(gradient, RoundedCornerShape(50.dp))
                ) {
                    Text("<--", fontSize = actionTextSize, color = Color.White, maxLines = 1)
                }
                Button(
                    onClick = { actualizarTematica() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .background(gradient, RoundedCornerShape(50.dp))
                ) {
                    Text(
                        "Cambiar temática",
                        fontSize = actionTextSize,
                        color = Color.White,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tematica,
                    fontSize = themeTextSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = pagePadding)
                )
            }
        }
    }
}
