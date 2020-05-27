package com.example.cleanarchproject.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchproject.ui.base.BaseViewModel
import com.example.cleanarchproject.utils.SingleLiveEvent

class NoteSharedViewModel : BaseViewModel() {
    val openNote = SingleLiveEvent<Boolean>()
    val openAddNewNote = SingleLiveEvent<Boolean>()
//    val title = SingleLiveEvent<String>()
    private val _title =MutableLiveData<String>()
    val title :LiveData<String>
    get() = _title

    init {
        openNote()
    }

    private fun openNote() {
        openNote.value = true
    }

    fun openAddNewNote() {
        openAddNewNote.value = true
    }

    fun setTitle(title:String){
        _title.value =title
    }
}