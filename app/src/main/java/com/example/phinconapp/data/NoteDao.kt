package com.example.phinconapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: List<Note>)

    @Query("SELECT * FROM Note")
    fun getAllNote(): Flow<List<Note>>

    @Query("SELECT * FROM Note ORDER BY text ASC")
    fun sortByText (): Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE emotion < :number")
    fun filterEmotionLessThan(number: Int): Flow<List<Note>>

    @Query("SELECT* FROM Note WHERE emotion > :number")
    fun filterEmotionGreaterThan(number: Int): Flow<List<Note>>
}