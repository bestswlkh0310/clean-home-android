package com.bestswlkh0310.clean_home.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember


@Composable
fun HomeView() {

    var items by remember { arrayListOf() }

    Column {
        LazyColumn {
            items() {

            }
        }
    }
}