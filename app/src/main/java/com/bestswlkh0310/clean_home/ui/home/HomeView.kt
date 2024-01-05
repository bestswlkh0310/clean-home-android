package com.bestswlkh0310.clean_home.ui.home

import android.content.ClipData.Item
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bestswlkh0310.clean_home.service.api.UserApi
import com.bestswlkh0310.clean_home.ui.root.NavGroup


@Composable
fun HomeView(
    navController: NavController
) {

    var items by remember { mutableStateOf(arrayListOf<Item>()) }

    LaunchedEffect(Unit) {

    }

    Column {
        Row {
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigate(NavGroup.My.id)
            }) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
        }

        LazyColumn {
            items(items) {

            }
        }
    }
}