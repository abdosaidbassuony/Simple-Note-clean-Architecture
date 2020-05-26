package com.example.cleanarchproject.ui.note.noteFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cleanarchproject.R
import com.example.cleanarchproject.databinding.FragmentNoteBinding
import com.example.cleanarchproject.ui.base.BaseFragment
import com.example.cleanarchproject.ui.note.NoteSharedViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass.
 */
class NoteFragment : BaseFragment<FragmentNoteBinding>() {
    override val viewModel by inject<NoteViewModel>()
    private val sharedViewModel by sharedViewModel<NoteSharedViewModel>()
    override val layoutId: Int = R.layout.fragment_note
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.addNewNote.setOnClickListener {
           sharedViewModel.openAddNewNote()
        }

    }

    companion object {
        fun newInstance() = NoteFragment()
    }
}
