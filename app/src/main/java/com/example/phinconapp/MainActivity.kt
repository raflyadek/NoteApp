package com.example.phinconapp

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.phinconapp.navigation.NavigationGraph
import com.example.phinconapp.ui.theme.PhinconAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhinconAppTheme {
                NoteApp()
            }
        }
    }
}

@Composable
fun NoteApp() {
    val navController = rememberNavController()
    Scaffold(
        contentWindowInsets = WindowInsets(0.dp)
    ) { paddingValue ->
        NavigationGraph(
            navController = navController,
            paddingValues = paddingValue
        )
    }
}

//note safe app where users can feel safe to dump they feeling by writing it in this app

//after splash screen there will be a screen to check percentage of emotion user have at the moment
//you cant skip this screen because we encourage user to tell a story everyday/every they open the app

//after that, straight into the note screen where user can tell a story/event that make user happy/sad

//and after tell a story, home screen where you can track/check what emotions/story you have on other day

//CRUD