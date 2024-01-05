package com.bestswlkh0310.clean_home.ui.my.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.clean_home.ui.theme.Body
import com.bestswlkh0310.clean_home.ui.theme.ButtonType
import com.bestswlkh0310.clean_home.ui.theme.CHButton
import com.bestswlkh0310.clean_home.ui.theme.Label

@Composable
fun InfoCeil(
    modifier: Modifier = Modifier,
    key: String,
    value: String,
    changeName: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Label(text = key, color = Color.LightGray)
            Body(text = value)
        }
        CHButton(text = "프로필 수정", type = ButtonType.None) {
            changeName()
        }
    }
}