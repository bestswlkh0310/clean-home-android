package com.bestswlkh0310.clean_home.ui.my.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.bestswlkh0310.clean_home.ui.theme.Body
import com.bestswlkh0310.clean_home.ui.theme.Label

@Composable
fun InfoCeil(
    key: String,
    value: String
) {
    Column {
        Label(text = key)
        Body(text = value)
    }
}