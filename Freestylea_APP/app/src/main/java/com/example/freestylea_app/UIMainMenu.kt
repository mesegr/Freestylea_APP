package com.example.freestylea_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UIMainMenu(
    onBotonPalabrasClick: () -> Unit,
    onBotonTematicasClick: () -> Unit,
    onBotonTerminacionesClick: () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondomain),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        val compact = maxWidth < 700.dp
        val titleSize = (maxWidth.value * 0.105f).coerceIn(28f, 60f).sp
        val buttonTextSize = (maxWidth.value * 0.055f).coerceIn(18f, 35f).sp

        Column(
            modifier = Modifier
                .fillMaxWidth(if (compact) 0.92f else 0.96f)
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(if (compact) 22.dp else 34.dp)
        ) {
            Text(
                text = "Elige que formato practicar",
                color = Color.White,
                fontSize = titleSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            if (compact) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.86f),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Buttons("Tematicas", onBotonTematicasClick, buttonTextSize)
                    Buttons("Palabras aleatorias", onBotonPalabrasClick, buttonTextSize, maxLines = 2)
                    Buttons("Terminaciones", onBotonTerminacionesClick, buttonTextSize)
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Buttons("Tematicas", onBotonTematicasClick, buttonTextSize, Modifier.weight(1f))
                    Buttons("Palabras aleatorias", onBotonPalabrasClick, buttonTextSize, Modifier.weight(1f), maxLines = 2)
                    Buttons("Terminaciones", onBotonTerminacionesClick, buttonTextSize, Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun Buttons(
    text: String,
    onClick: () -> Unit,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    maxLines: Int = 1
) {
    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFFFF00AA), Color(0xFF0037FF), Color(0xFF4CC9FF))
    )

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 76.dp)
            .padding(4.dp)
            .background(gradient, RoundedCornerShape(30.dp))
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = (fontSize.value * 0.82f).coerceAtLeast(14f).sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = (fontSize.value * 1.2f).sp,
            maxLines = maxLines,
            softWrap = maxLines > 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 12.dp)
        )
    }
}
