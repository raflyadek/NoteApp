package com.example.phinconapp

import com.example.phinconapp.data.Note
import com.example.phinconapp.data.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    fun getAllNote() = noteDao.getAllNote()

    suspend fun insertNote(datamodel: Note)
    = noteDao.insert(datamodel)

    suspend fun deleteNote(allData: List<Note>)
    = noteDao.delete(allData)

    suspend fun updateNote(allData: Note)
    = noteDao.update(allData)
}