package com.example.phinconapp

import android.content.Context
import com.example.phinconapp.data.NoteDatabase

class NoteContainer(private val context: Context) {
    val noteRepository: NoteRepository by lazy {
        NoteRepository(NoteDatabase.getNoteDatabase(context).noteDao())
    }
}