package com.example.phinconapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: DataModel)

    @Update
    suspend fun update(note: DataModel)

    @Delete
    suspend fun delete(note: DataModel)

    @Query("SELECT * FROM datamodel")
    fun getNote(): Flow<List<DataModel>>

    @Query("SELECT * FROM datamodel ORDER BY text ASC")
    fun sortByText (): Flow<List<DataModel>>

    @Query("SELECT * FROM datamodel WHERE emotion < :number")
    fun filterEmotionLessThan(number: Int): Flow<List<DataModel>>

    @Query("SELECT* FROM datamodel WHERE emotion > :number")
    fun filterEmotionGreaterThan(number: Int): Flow<List<DataModel>>
}