package com.bestswlkh0310.clean_home.ui.root

sealed class NavGroup(
    val id: String,
    val title: String
) {
    object Main: NavGroup("MAIN", "메인")
    object Home: NavGroup("HOME", "홈")
    object Profile: NavGroup("PROFILE", "MY")
}