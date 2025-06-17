package com.example.freestylea_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun UIMainMenu(
    onBotonPalabrasClick: () -> Unit,
    onBotonTematicasClick: () -> Unit,
    onBotonTerminacionesClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondomain),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Elige que formato practicar",
                color = Color.White,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 70.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Buttons(
                    text = "Tematicas",
                    onClick = onBotonTematicasClick,
                    fontSize = 35.sp,
                    buttonWidth = 260.dp,
                    buttonHeight = 160.dp
                )
                Buttons(
                    text = "Palabras aleatorias",
                    onClick = onBotonPalabrasClick,
                    fontSize = 35.sp,
                    buttonWidth = 200.dp,
                    buttonHeight = 180.dp
                )
                Buttons(
                    text = "Terminaciones",
                    onClick = onBotonTerminacionesClick,
                    fontSize = 34.sp,
                    buttonWidth = 260.dp,
                    buttonHeight = 160.dp
                )
            }
        }
    }
}

@Composable
fun Buttons(
    text: String,
    onClick: () -> Unit,
    fontSize: TextUnit = 35.sp,
    buttonWidth: Dp = 200.dp,
    buttonHeight: Dp = 180.dp,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
            .width(buttonWidth)
            .height(buttonHeight)
            .padding(8.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFF00AA),
                        Color(0xFF0037FF),
                        Color(0xFF4CC9FF)
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                ),
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Text(
            text,
            color = Color.White,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 46.sp
        )
    }
}