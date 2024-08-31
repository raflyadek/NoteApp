package com.example.phinconapp.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phinconapp.NoteRepository
import com.example.phinconapp.data.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel(private val noteRepository: NoteRepository): ViewModel() {
    fun getAll(): Flow<List<Note>>
    = noteRepository.getAllNote()

    fun insertNote(text: String, title: String, emotion: Int) = viewModelScope.launch {
        noteRepository.insertNote(Note(
            text = text, title = title, emotion = emotion)
        )
    }

    fun deleteNote(allNote: List<Note>) = viewModelScope.launch {
        noteRepository.deleteNote(allNote)
    }

    fun updateNote(text: String, title: String, emotion: Int) = viewModelScope.launch {
        noteRepository.updateNote(Note(
            text = text, title = title, emotion = emotion)
        )
    }
}