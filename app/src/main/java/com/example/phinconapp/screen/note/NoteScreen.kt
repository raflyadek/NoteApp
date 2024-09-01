package com.example.phinconapp.screen.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.phinconapp.base.BasicTextNote
import com.example.phinconapp.data.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(navController: NavController, noteId: Int, paddingValues: PaddingValues, viewModel: NoteViewModel = viewModel(factory = NoteViewModel.Factory)) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    val isNewNote = noteId == -1

    //use collectasstate to observe the note data
    val noteState by viewModel.noteState.collectAsState()

    //load note if update
    LaunchedEffect(noteId) {
        if(!isNewNote) {
            viewModel.loadNote(noteId)
        }
    }

    //update title and content when notestate change
    LaunchedEffect(noteState) {
        noteState?.let { note ->
            title = note.title
            content = note.text
        }
    }
    Scaffold(
        modifier = Modifier
            .padding(paddingValues),
        topBar = {
            TopAppBar(
                title = { Text(if (isNewNote) "All note" else "Update") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = "Back" )
                    }
                },
                actions = {
                    TextButton(onClick = {if (isNewNote) {
                        viewModel.insertNote(Note(text = content, title = title))
                    } else {
                        viewModel.updateNote(Note(id = noteId, title = title, text = content))
                    }
                        navController.popBackStack()
                    }) {
                        Text(text = "save", color = Color.Black)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 25.dp)
            ) {
                BasicTextNote(
                    title = title,
                    content = content,
                    onTitleChange = { title = it},
                    onContentChange = { content = it}
                )
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun InternalPreviewNote() {
//    PhinconAppTheme {
//        NoteScreen(
//            onBack = {},
//            paddingValues = PaddingValues(4.dp),
//            onDone = {}
//        )
//    }
//}