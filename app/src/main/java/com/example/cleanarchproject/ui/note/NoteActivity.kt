package com.example.cleanarchproject.ui.note

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.cleanarchproject.R
import com.example.cleanarchproject.databinding.ActivityNoteBinding
import com.example.cleanarchproject.ui.base.BaseActivity
import com.example.cleanarchproject.ui.note.noteFragment.NoteFragment
import com.example.cleanarchproject.utils.openFragment
import org.koin.android.ext.android.inject
import timber.log.Timber

class NoteActivity : BaseActivity<ActivityNoteBinding>() {
    override val layoutId: Int = R.layout.activity_note
    override val viewModel by inject<NoteSharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.e("NoteActivity")
        initObservers()
    }

  private fun initObservers(){
        viewModel.openNote.observe(this, Observer {
          openFragment(R.id.container,NoteFragment.newInstance(),false)
        })
    }

}
