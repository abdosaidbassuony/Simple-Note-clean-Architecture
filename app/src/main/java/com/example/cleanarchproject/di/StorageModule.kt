package com.example.cleanarchproject.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchproject.data.local.AppDatabase
import com.example.cleanarchproject.data.local.NoteDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val storageModule = module {
    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "note.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideDao(database: AppDatabase): NoteDao {
        return database.noteDoa
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}