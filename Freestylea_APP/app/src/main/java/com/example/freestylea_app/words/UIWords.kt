package com.example.freestylea_app.words

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Brush
import com.example.freestylea_app.R

@Composable
fun UIWords(onBack: () -> Unit) {
    val wordGenerator = remember { WordGenerator() }
    val delayValues = mapOf(
        "2s" to 2_000L,
        "5s" to 5_000L,
        "7,5s" to 7_500L,
        "10s" to 10_000L,
        "15s" to 15_000L,
        "20s" to 20_000L
    )
    var selectedDelay by remember { mutableStateOf(wordGenerator.getDelay()) }
    val delayText = delayValues.entries.find { it.value == selectedDelay }?.key ?: "2s"

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BotonesDelay(
                selectedDelayText = delayText,
                wordGenerator = wordGenerator,
                delayValues = delayValues,
                onDelayChange = { newDelay ->
                    wordGenerator.setDelay(newDelay)
                    selectedDelay = newDelay
                },
                onBack = onBack
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                contentAlignment = Alignment.Center
            ) {
                Palabra(wordGenerator)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 1.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Tiempo(delayText)
            }
        }
    }
}

@Composable
fun Palabra(wordGenerator: WordGenerator) {
    var palabra by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        wordGenerator.startWordStream { nuevaPalabra ->
            palabra = nuevaPalabra
        }
    }

    Text(
        text = palabra,
        fontSize = 75.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun Tiempo(delay: String) {
    Text(
        text = "Palabras cada $delay",
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun BotonesDelay(
    selectedDelayText: String,
    wordGenerator: WordGenerator,
    delayValues: Map<String, Long>,
    onDelayChange: (Long) -> Unit,
    onBack: () -> Unit
) {
    val delays = delayValues.keys.toList()
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFF00AA),
            Color(0xFF0037FF),
            Color(0xFF4CC9FF)
        )
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Botón de volver atrás
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 6.dp)
                .background(gradient, shape = RoundedCornerShape(50.dp))
                .weight(0.92f)
                .height(44.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "<--", // Flecha hacia atrás
                    fontSize = 18.sp,
                    color = Color.White,
                    maxLines = 1
                )
            }
        }
        // Botones de delay
        delays.forEach { texto ->
            val delayValue = delayValues[texto] ?: 2_000L
            Button(
                onClick = { onDelayChange(delayValue) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedDelayText == texto) Color.Green else Color.Transparent,
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp, vertical = 6.dp)
                    .background(gradient, shape = RoundedCornerShape(50.dp))
            ) {
                Text(
                    texto,
                    fontSize = 28.sp,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}


