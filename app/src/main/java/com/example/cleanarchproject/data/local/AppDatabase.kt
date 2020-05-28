package com.example.cleanarchproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchproject.domain.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val noteDoa: NoteDao
}