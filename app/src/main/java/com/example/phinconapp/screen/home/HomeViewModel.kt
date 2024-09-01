package com.example.phinconapp.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.phinconapp.NoteApplication
import com.example.phinconapp.NoteRepository
import com.example.phinconapp.data.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel(private val noteRepository: NoteRepository): ViewModel() {
    fun getAll(): Flow<List<Note>>
    = noteRepository.getAllNote()

    fun insertNote(text: String, title: String) = viewModelScope.launch {
        noteRepository.insertNote(Note(
            text = text, title = title)
        )
    }

    fun deleteNote(allNote: Note) = viewModelScope.launch {
        noteRepository.deleteNote(allNote)
    }

    fun updateNote(text: String, title: String, emotion: Int) = viewModelScope.launch {
        noteRepository.updateNote(Note(
            text = text, title = title)
        )
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as NoteApplication)
                HomeViewModel(application.container.noteRepository)
            }
        }
    }
}

