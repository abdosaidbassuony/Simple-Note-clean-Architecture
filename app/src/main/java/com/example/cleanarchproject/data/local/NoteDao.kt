package com.example.cleanarchproject.data.local

import androidx.room.*
import com.example.cleanarchproject.domain.Note
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Single<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note): Completable

    @Update
    fun updateNote(note: Note): Completable

    @Delete
    fun deleteNote(note: Note): Completable
}