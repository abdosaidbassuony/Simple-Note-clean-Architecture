package com.example.cleanarchproject.ui.note

import com.example.cleanarchproject.ui.base.BaseViewModel
import com.example.cleanarchproject.utils.SingleLiveEvent

class NoteSharedViewModel : BaseViewModel() {
    val openNote = SingleLiveEvent<Boolean>()
    val openAddNewNote = SingleLiveEvent<Boolean>()

    init {
        openNote()
    }

    private fun openNote() {
        openNote.value = true
    }

    fun openAddNewNote() {
        openAddNewNote.value = true
    }
}