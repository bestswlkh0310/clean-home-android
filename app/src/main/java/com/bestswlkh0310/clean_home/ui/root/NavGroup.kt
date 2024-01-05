package com.bestswlkh0310.clean_home.ui.root

sealed class NavGroup(
    val id: String,
    val title: String
) {
    object Home: NavGroup("HOME", "홈")
    object My: NavGroup("MY", "MY")
    object MyFix: NavGroup("MY_FIX", "프로필 수정")
}