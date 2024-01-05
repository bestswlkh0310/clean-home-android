package com.bestswlkh0310.clean_home.ui.my

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bestswlkh0310.clean_home.model.UserModel
import com.bestswlkh0310.clean_home.service.HttpClient.userApi
import com.bestswlkh0310.clean_home.util.TAG
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyView(
    navController: NavController
) {

    val coroutine = rememberCoroutineScope()
    var user by remember { mutableStateOf<UserModel?>(null) }

    LaunchedEffect(Unit) {
        coroutine.launch {
            val response = userApi.getUser()
            Log.d(TAG, "$response - MyView() called")
            user = response
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                ),
                title = {
                    Text(
                        text = "MY",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (user == null) {
                Text(text = "...로딩중")
            } else {
                Row {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        text = "이름",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = user!!.name)

                }
                Row {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 8.dp),
                        text = "잔액",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "${user!!.cost}원")
                }
            }
        }
    }

}