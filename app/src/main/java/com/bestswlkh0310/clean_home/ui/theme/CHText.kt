package com.bestswlkh0310.clean_home.ui.theme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Title(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp
        ),
        color = color
    )
}

@Composable
fun Body(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        ),
        color = color
    )
}


@Composable
fun Label(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        ),
        color = color
    )
}

