package com.bestswlkh0310.clean_home.ui.my

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bestswlkh0310.clean_home.model.UserModel
import com.bestswlkh0310.clean_home.service.HttpClient.userApi
import com.bestswlkh0310.clean_home.ui.my.component.InfoCeil
import com.bestswlkh0310.clean_home.ui.root.NavGroup
import com.bestswlkh0310.clean_home.ui.theme.Body
import com.bestswlkh0310.clean_home.ui.theme.CHTopBar
import com.bestswlkh0310.clean_home.ui.theme.Label
import com.bestswlkh0310.clean_home.ui.theme.Title
import com.bestswlkh0310.clean_home.ui.theme.shadow1
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
            CHTopBar(title = NavGroup.My.title) {
                navController.popBackStack()
            }
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

                val user = user!!
                Row(
                    modifier = Modifier
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )

                    InfoCeil(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp),
                        key = "이름",
                        value = user.name
                    ) {

                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .shadow1()
                        .background(Color.White)
                        .padding(16.dp),
                ) {
                    Label(text = "잔액", color = Color.LightGray)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Title(text = "${user.cost}원")
                        Icon(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .align(Alignment.Bottom),
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }

}