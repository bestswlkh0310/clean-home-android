package com.bestswlkh0310.clean_home.ui.root

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bestswlkh0310.clean_home.ui.home.HomeView
import com.bestswlkh0310.clean_home.ui.my.MyView
import com.bestswlkh0310.clean_home.ui.myfix.MyFix

@Composable
fun NavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = NavGroup.Home.id
    ) {
        composable(NavGroup.My.id) {
            MyView(navController = navController)
        }
        composable(NavGroup.Home.id) {
            HomeView(navController = navController)
        }
        composable(NavGroup.MyFix.id) {
            MyFix(navController = navController)
        }
    }
}