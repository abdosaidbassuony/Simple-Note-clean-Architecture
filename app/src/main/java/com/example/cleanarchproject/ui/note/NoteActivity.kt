package com.example.cleanarchproject.ui.note

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.cleanarchproject.R
import com.example.cleanarchproject.databinding.ActivityNoteBinding
import com.example.cleanarchproject.ui.base.BaseActivity
import com.example.cleanarchproject.ui.note.addnote.AddNewNoteFragment
import com.example.cleanarchproject.ui.note.noteFragment.NoteFragment
import com.example.cleanarchproject.utils.openFragment
import org.koin.android.viewmodel.ext.android.viewModel

class NoteActivity : BaseActivity<ActivityNoteBinding>() {
    override val layoutId: Int = R.layout.activity_note
    override val viewModel by viewModel<NoteSharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        viewModel.openNote.observe(this, Observer {
            if (it) {
                openFragment(R.id.container, NoteFragment.newInstance(), true)
            }
        })
        viewModel.openAddNewNote.observe(this, Observer {
            if (it) {
                openFragment(R.id.container, AddNewNoteFragment.newInstance(), true)
            }
        })
        viewModel.title.observe(this, Observer {
            supportActionBar?.title = it
        })

    }
    private fun initListeners() {
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount > 1) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setDisplayShowHomeEnabled(false)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}
