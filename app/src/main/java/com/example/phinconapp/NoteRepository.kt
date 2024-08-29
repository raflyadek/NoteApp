package com.example.phinconapp

import com.example.phinconapp.data.DataModel
import com.example.phinconapp.data.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    fun getAllNote() = noteDao.getAllNote()

    suspend fun insertNote(datamodel: DataModel)
    = noteDao.insert(datamodel)

    suspend fun deleteNote(allData: List<DataModel>)
    = noteDao.delete(allData)

    suspend fun updateNote(allData: DataModel)
    = noteDao.update(allData)
}