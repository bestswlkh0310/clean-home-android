package com.bestswlkh0310.clean_home.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

sealed class ButtonType(
    val backgroundColor: Color,
    val foregroundColor: Color,
    val strokeColor: Color
) {
    data object Main: ButtonType(
        backgroundColor = CHColor.main500,
        foregroundColor = Color.White,
        strokeColor = Color.Transparent
    )

    data object Sub: ButtonType(
        backgroundColor = Color.White,
        foregroundColor = CHColor.main500,
        strokeColor = CHColor.main500
    )

    data object None: ButtonType(
        backgroundColor = CHColor.gray50,
        foregroundColor = Color.Black,
        strokeColor = Color.Transparent
    )
}

@Composable
fun CHButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    type: ButtonType = ButtonType.Main,
    shape: Shape = RoundedCornerShape(50),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentPadding: PaddingValues = PaddingValues(vertical = 4.dp, horizontal = 8.dp),
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .shadow1(),
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = type.backgroundColor
        ),
        interactionSource = interactionSource,
        contentPadding = PaddingValues(),
        border = BorderStroke(width = (1.5).dp, color = type.strokeColor)
    ) {
        Column(
            modifier = Modifier
                .padding(contentPadding)
        ) {
            Label(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = text,
                color = type.foregroundColor
            )
        }
    }
}