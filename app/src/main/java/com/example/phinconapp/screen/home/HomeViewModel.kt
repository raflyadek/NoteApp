package com.example.phinconapp.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.phinconapp.NoteRepository
import com.example.phinconapp.data.DataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class HomeViewModel(private val noteRepository: NoteRepository): ViewModel() {
    fun getAll(): Flow<List<DataModel>>
    = noteRepository.getAllNote()

    fun insertNote(text: String, emotion: Int) = viewModelScope.launch {
        noteRepository.insertNote(DataModel(
            text = text, emotion = emotion)
        )
    }

    fun deleteNote(allNote: List<DataModel>) = viewModelScope.launch {
        noteRepository.deleteNote(allNote)
    }

    fun updateNote()
}