package com.bestswlkh0310.clean_home.ui.myfix

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bestswlkh0310.clean_home.application.CleanHomeApplication
import com.bestswlkh0310.clean_home.model.UserModel
import com.bestswlkh0310.clean_home.service.HttpClient.userApi
import com.bestswlkh0310.clean_home.ui.root.NavGroup
import com.bestswlkh0310.clean_home.ui.theme.Body
import com.bestswlkh0310.clean_home.ui.theme.CHButton
import com.bestswlkh0310.clean_home.ui.theme.CHTextField
import com.bestswlkh0310.clean_home.ui.theme.CHTopBar
import kotlinx.coroutines.launch

@Composable
fun MyFix(
    navController: NavController
) {

    var name by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutine.launch {
            name = userApi.getUser().name
        }
    }

    Scaffold(
        topBar = {
            CHTopBar(title = NavGroup.MyFix.title) {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .padding(horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Body(
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                    text = "이름"
                )
                CHTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = name,
                    onValueChange = { name = it }
                )
            }

            CHButton(
                modifier = Modifier
                    .padding(top = 24.dp),
                text = "수정 완료"
            ) {
                coroutine.launch {
                    userApi.fixName(userModel = UserModel(
                        id = CleanHomeApplication.prefs.id,
                        name = name
                    ))
                    navController.popBackStack()
                }
            }
        }
    }
}