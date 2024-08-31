package com.example.phinconapp.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.phinconapp.ui.theme.PhinconAppTheme

@Composable
fun Spacer(size: Dp) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.size(size))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolbar(title: String, useArrowBack: Boolean? = false, onBack: () -> Unit) {
    TopAppBar(
        windowInsets = WindowInsets(0.dp),
        title = {
            Text(text = title)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.scrim
        ),
//        actions = button done buat ngilangin keyboard kalou udah selesai nulis + save,
        navigationIcon = {
            if (useArrowBack == true) {
                IconButton(onClick = { onBack() }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}

@Composable
fun BasicTextNote(
    title: String,
    content: String,
    onTitleChange: (String) -> Unit,
    onContentChange: (String) -> Unit,
) {
    BasicTextField(
        value = title,
        onValueChange = onTitleChange,
        textStyle = TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )

    Spacer(size = 8.dp)

    BasicTextField(
        value = content,
        onValueChange = onContentChange,
        textStyle = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .fillMaxSize()
    )
}



@Composable
@Preview(showBackground = true)
fun InternalPreview() {
    PhinconAppTheme {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            CustomToolbar(title = "title", useArrowBack = true) {
                
            }
        }
    }
}