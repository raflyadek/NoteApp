package com.example.phinconapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.phinconapp.screen.home.HomeScreen
import com.example.phinconapp.screen.note.NoteScreen


@Composable
fun NavigationGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(navController = navController, startDestination = Screens.Note.route) {
        composable(Screens.Check.route) {
            //CheckScreen()
        }
        composable(Screens.Note.route) {
            NoteScreen(
                onBack = { navController.navigate(Screens.Home.route) },
                paddingValues = paddingValues
            )
        }
        composable(Screens.Home.route) {
            HomeScreen(
                navController = navController,
                paddingValues = paddingValues,
                onItemClicked = { navController.navigate(Screens.Note.route)}
            )
        }
    }
}