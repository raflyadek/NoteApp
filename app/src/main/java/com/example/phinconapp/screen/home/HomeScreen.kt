package com.example.phinconapp.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.phinconapp.base.CustomToolbar

@Composable
fun HomeScreen(navController: NavController, onItemClicked: () -> Unit, paddingValues: PaddingValues, viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)) {
    val noteList by viewModel.getAll().collectAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier.padding(paddingValues),
        contentWindowInsets = WindowInsets(0.dp),
        topBar = {
            CustomToolbar(title = "Note") {
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            ) {
                items(noteList) { note ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable { onItemClicked() },
                        colors = CardDefaults.cardColors(
                            containerColor = Color.DarkGray
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                        ) {
                            ConstraintLayout(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                val (title, content) = createRefs()

                                Text(
                                    text = note.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    modifier = Modifier
                                        .constrainAs(title) {
                                            top.linkTo(parent.top)
                                            start.linkTo(parent.start, 10.dp)
                                        }
                                )
                                Text(
                                    text = note.text,
                                    fontSize = 10.sp,
                                    color = Color.LightGray,
                                    modifier = Modifier
                                        .constrainAs(content) {
                                            top.linkTo(title.bottom, 4.dp)
                                            start.linkTo(parent.start, 10.dp)
                                        }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomePreview() {
    HomeScreen(navController = rememberNavController(), onItemClicked = {}, paddingValues = PaddingValues())
}