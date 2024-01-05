package com.bestswlkh0310.clean_home.ui.home

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController


@Composable
fun HomeView(
    navController: NavController
) {

    var items by remember { mutableStateOf(arrayListOf<Item>()) }

    Column {
        LazyColumn {
            items(items) {

            }
        }
    }
}