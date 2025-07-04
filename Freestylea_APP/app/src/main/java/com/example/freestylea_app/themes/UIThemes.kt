package com.example.freestylea_app.themes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.freestylea_app.R

@Composable
fun Tematica(themeGenerator: ThemeGenerator, onBack: () -> Unit) {
    var tematica by remember { mutableStateOf("") }

    // Función para actualizar la temática
    fun actualizarTematica() {
        themeGenerator.getRandomTheme { nuevaTematica ->
            tematica = nuevaTematica
        }
    }

    // Cargar temática al entrar
    LaunchedEffect(Unit) {
        actualizarTematica()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
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
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Botón volver (izquierda)
                Button(
                    onClick = onBack,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .background(gradient, shape = RoundedCornerShape(50.dp))
                        .height(44.dp)
                ) {
                    Text(
                        "<--",
                        fontSize = 18.sp,
                        color = Color.White,
                        maxLines = 1
                    )
                }
                // Botón cambiar temática (derecha)
                Button(
                    onClick = { actualizarTematica() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .background(gradient, shape = RoundedCornerShape(50.dp))
                        .height(44.dp)
                ) {
                    Text(
                        "Cambiar temática",
                        fontSize = 26.sp,
                        color = Color.White,
                        maxLines = 1
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tematica,
                    fontSize = 76.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}