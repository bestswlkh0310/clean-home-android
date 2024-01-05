package com.bestswlkh0310.clean_home.ui.my

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController

@Composable
fun MyView(
    navController: NavController
) {

    LaunchedEffect(Unit) {

    }

    Column {
        Text(text = "...로딩중")
        Text(text = "잔액: ")
    }
}