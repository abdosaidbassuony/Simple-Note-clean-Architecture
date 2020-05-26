package com.example.cleanarchproject.ui.note

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.cleanarchproject.R
import com.example.cleanarchproject.databinding.ActivityNoteBinding
import com.example.cleanarchproject.ui.base.BaseActivity
import com.example.cleanarchproject.ui.note.addnote.AddNewNoteFragment
import com.example.cleanarchproject.ui.note.noteFragment.NoteFragment
import com.example.cleanarchproject.utils.openFragment
import org.koin.android.ext.android.inject

class NoteActivity : BaseActivity<ActivityNoteBinding>() {
    override val layoutId: Int = R.layout.activity_note
    override val viewModel by inject<NoteSharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
    }

  private fun initObservers(){
      viewModel.openNote.observe(this, Observer {
          if (it){
              openFragment(R.id.container,NoteFragment.newInstance(),false)
          }
        })
     viewModel.openAddNewNote.observe(this, Observer {
         if (it){
             openFragment(R.id.container,AddNewNoteFragment.newInstance(),false)
         }
     })

  }

}
