package com.example.freestylea_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.freestylea_app.themes.Tematica
import com.example.freestylea_app.words.UIWords
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.freestylea_app.Terminaciones.Terminacion
import com.example.freestylea_app.Terminaciones.terminacionGenerator
import com.example.freestylea_app.UIMainMenu
import com.example.freestylea_app.themes.Tematica
import com.example.freestylea_app.themes.ThemeGenerator


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var pantallaActual by remember { mutableStateOf("menu") }
            val themeGenerator = remember { ThemeGenerator() }
            val terminacionGenerator = remember { terminacionGenerator() }

            when (pantallaActual) {
                "menu" -> UIMainMenu(
                    onBotonPalabrasClick = { pantallaActual = "palabras" },
                    onBotonTematicasClick = { pantallaActual = "tematicas" },
                    onBotonTerminacionesClick = { pantallaActual = "terminaciones" }
                )
                "palabras" -> UIWords(onBack = { pantallaActual = "menu" })
                "tematicas" -> Tematica(
                    themeGenerator = themeGenerator,
                    onBack = { pantallaActual = "menu" }
                )
                "terminaciones" -> Terminacion(
                    themeGenerator = terminacionGenerator,
                    onBack = { pantallaActual = "menu" }
                )
            }
        }
    }
}

@Composable
fun PantallaPrincipal() {
    var mostrarPalabras by remember { mutableStateOf(false) }
    var mostrarTematicas by remember { mutableStateOf(false) }
    val themeGenerator = remember { ThemeGenerator() }

    when {
        mostrarPalabras -> UIWords(onBack = { mostrarPalabras = false })
        mostrarTematicas -> Tematica(themeGenerator = themeGenerator, onBack = { mostrarTematicas = false })
        else -> UIMainMenu(
            onBotonPalabrasClick = { mostrarPalabras = true },
            onBotonTematicasClick = { mostrarTematicas = true },
            onBotonTerminacionesClick = { mostrarTematicas = true }
        )
    }
}

