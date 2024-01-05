package com.bestswlkh0310.clean_home.ui.myfix

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bestswlkh0310.clean_home.ui.root.NavGroup
import com.bestswlkh0310.clean_home.ui.theme.CHTopBar

@Composable
fun MyFix(
    navController: NavController
) {
    Scaffold(
        topBar = {
            CHTopBar(title = NavGroup.MyFix.title) {
                navController.popBackStack()
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {

        }
    }
}