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
import com.example.freestylea_app.words.UIWords

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaPrincipal()
        }
    }
}

@Composable
fun PantallaPrincipal() {
    var mostrarPalabras by remember { mutableStateOf(false) }
    val uiController = remember { UIController.UIController { mostrarPalabras = true } }

    if (mostrarPalabras) {
        UIWords(onBack = { mostrarPalabras = false })
    } else {
        UIMainMenu(
            onBotonClick = { uiController.FormatoPalabras() }
        )
    }
}

