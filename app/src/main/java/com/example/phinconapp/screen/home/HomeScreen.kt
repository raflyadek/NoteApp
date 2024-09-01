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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.phinconapp.base.ExtendedFab

@Composable
fun HomeScreen(navController: NavController, onClickToNote: () -> Unit, onItemClicked: () -> Unit, paddingValues: PaddingValues, viewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory)) {
    val noteList by viewModel.getAll().collectAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),

        contentWindowInsets = WindowInsets(0.dp),
        floatingActionButton = {
            ExtendedFab(onClick = { navController.navigate("note/-1")})
        },
        floatingActionButtonPosition = FabPosition.End,
        topBar = {
            CustomToolbar(title = "Note", onDone = {}) {
            }
        },
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
                            .clickable { navController.navigate("note/${note.id}")}
                            ,
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
                                val (title, content, deleteIcon) = createRefs()

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
                                IconButton(
                                    onClick = { viewModel.deleteNote(note)},
                                    modifier = Modifier
                                        .constrainAs(deleteIcon) {
                                            end.linkTo(parent.end)
                                        }
                                ) {
                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = "delete-note",)
                                }
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
    HomeScreen(onClickToNote = {}, navController = rememberNavController(), onItemClicked = {}, paddingValues = PaddingValues())
}