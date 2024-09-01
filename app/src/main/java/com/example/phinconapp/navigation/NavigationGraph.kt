package com.example.phinconapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.phinconapp.screen.home.HomeScreen
import com.example.phinconapp.screen.note.NoteScreen


@Composable
fun NavigationGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Check.route) {
            //CheckScreen()
        }
        composable(Screens.Note.route, arguments = listOf(navArgument("noteId") {type = NavType.IntType})) {backstackEntry ->
            val noteId = backstackEntry.arguments?.getInt("noteId") ?: -1
            NoteScreen(
                navController = navController,
                paddingValues = paddingValues,
                noteId = noteId
            )
        }
        composable(Screens.Home.route) {
            HomeScreen(
                navController = navController,
                paddingValues = paddingValues,
                onClickToNote = { navController.navigate(Screens.Note.route)},
                onItemClicked = { navController.navigate(Screens.Note.route)}
            )
        }
    }
}