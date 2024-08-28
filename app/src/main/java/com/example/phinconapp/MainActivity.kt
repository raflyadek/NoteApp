package com.example.phinconapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.phinconapp.ui.theme.PhinconAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhinconAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//note safe app where users can feel safe to dump they feeling by writing it in this app

//after splash screen there will be a screen to check percentage of emotion user have at the moment
//you cant skip this screen because we encourage user to tell a story everyday/every they open the app

//after that, straight into the note screen where user can tell a story/event that make user happy/sad

//and after tell a story, home screen where you can track/check what emotions/story you have on other day

//CRUD