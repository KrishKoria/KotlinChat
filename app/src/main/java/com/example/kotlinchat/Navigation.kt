package com.example.kotlinchat

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login")
    object SignupScreen : Screen("signup")
    object ChatRoomScreen : Screen("chatroomscreen")
    object ChatScreen : Screen("chatscreen")
}