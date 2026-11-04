package com.example.freestylea_app.words

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
@OptIn(ExperimentalLayoutApi::class)
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

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val responsiveWidth = maxWidth
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
                onBack = onBack,
                textSize = (responsiveWidth.value * 0.07f).coerceIn(18f, 28f).sp
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                contentAlignment = Alignment.Center
            ) {
                Palabra(
                    wordGenerator = wordGenerator,
                    textSize = (responsiveWidth.value * 0.19f).coerceIn(42f, 75f).sp
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 1.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Tiempo(
                    delay = delayText,
                    textSize = (responsiveWidth.value * 0.10f).coerceIn(24f, 40f).sp
                )
            }
        }
    }
}

@Composable
fun Palabra(wordGenerator: WordGenerator, textSize: androidx.compose.ui.unit.TextUnit) {
    var palabra by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        wordGenerator.startWordStream { nuevaPalabra ->
            palabra = nuevaPalabra
        }
    }

    Text(
        text = palabra,
        fontSize = textSize,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    )
}

@Composable
fun Tiempo(delay: String, textSize: androidx.compose.ui.unit.TextUnit) {
    Text(
        text = "Palabras cada $delay",
        fontSize = textSize,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun BotonesDelay(
    selectedDelayText: String,
    wordGenerator: WordGenerator,
    delayValues: Map<String, Long>,
    onDelayChange: (Long) -> Unit,
    onBack: () -> Unit,
    textSize: androidx.compose.ui.unit.TextUnit
) {
    val delays = delayValues.keys.toList()
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFF00AA),
            Color(0xFF0037FF),
            Color(0xFF4CC9FF)
        )
    )

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        maxItemsInEachRow = 4
    ) {
        // Botón de volver atrás
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 6.dp)
                .background(gradient, shape = RoundedCornerShape(50.dp))
                .weight(1f)
                .height(44.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "<--", // Flecha hacia atrás
                    fontSize = textSize,
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
                    fontSize = textSize,
                    color = Color.White,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}


