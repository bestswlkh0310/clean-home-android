package com.bestswlkh0310.clean_home.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bestswlkh0310.clean_home.model.ItemModel
import com.bestswlkh0310.clean_home.service.HttpClient.itemApi
import com.bestswlkh0310.clean_home.ui.root.NavGroup
import com.bestswlkh0310.clean_home.util.TAG
import kotlinx.coroutines.launch


@Composable
fun HomeView(
    navController: NavController
) {

    var items by remember { mutableStateOf(arrayListOf<ItemModel>()) }
    val coroutine = rememberCoroutineScope()


    LaunchedEffect(Unit) {
        coroutine.launch {
            // TODO : get items api
            try {
                val response = itemApi.getAll()
                Log.d(TAG, "${response[0]} - HomeView() called")
                items = response
            } catch (e: Exception) {
                Log.d(TAG, "${e.message} - HomeView() called")
            }
        }
    }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 12.dp),
                text = "청소하고 돈 받기",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                navController.navigate(NavGroup.My.id)
            }) {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
        }

        LazyColumn {
            items(items) {
                Text(text = it.itemName)
            }
        }
    }
}