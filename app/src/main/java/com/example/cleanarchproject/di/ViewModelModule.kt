package com.example.cleanarchproject.di

import com.example.cleanarchproject.ui.note.NoteSharedViewModel
import com.example.cleanarchproject.ui.note.noteFragment.NoteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        NoteSharedViewModel()
    }
    viewModel {
        NoteViewModel()
    }
}