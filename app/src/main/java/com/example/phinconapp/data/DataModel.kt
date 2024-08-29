package com.example.phinconapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
    val emotion: Int
)
