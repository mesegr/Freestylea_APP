package com.example.freestylea_app

class UIController {

    class UIController(private val onMostrarPalabras: () -> Unit) {
        fun FormatoPalabras() {
            onMostrarPalabras()
        }
    }

}