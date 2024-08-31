package com.example.phinconapp.navigation

sealed class Screens(val route: String, val title: String) {
    data object Home : Screens("home", "Home")
    data object Note : Screens("note", "Note")
    data object Check : Screens("check", "Check")
}