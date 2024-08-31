package com.example.phinconapp.screen.note

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phinconapp.base.BasicTextNote
import com.example.phinconapp.base.CustomToolbar
import com.example.phinconapp.ui.theme.PhinconAppTheme

@Composable
fun NoteScreen(onBack: () -> Unit, paddingValues: PaddingValues) {
    Scaffold(
        modifier = Modifier
            .padding(paddingValues),
        topBar = {
            CustomToolbar(
                title = "All note",
                useArrowBack = true) {
            }
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
                BasicTextIp()
            }
        }
    }
}

@Composable
fun BasicTextIp() {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    BasicTextNote(
        title = title,
        content = content,
        onTitleChange = { title = it},
        onContentChange = { content = it}
    )
}

@Preview(showBackground = true)
@Composable
fun InternalPreviewNote() {
    PhinconAppTheme {
        NoteScreen(
            onBack = {},
            paddingValues = PaddingValues(4.dp)
        )
    }
}