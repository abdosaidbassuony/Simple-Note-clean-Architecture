package com.example.cleanarchproject.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchproject.ui.base.BaseViewModel

class NoteSharedViewModel : BaseViewModel() {
    private val _openNote = MutableLiveData<Boolean>()
    val openNote: LiveData<Boolean>
        get() = _openNote

    init {
        openNote()
    }

    private fun openNote() {
        _openNote.value = true
    }
}