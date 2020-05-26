package com.example.cleanarchproject.ui.note.noteFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.cleanarchproject.R
import com.example.cleanarchproject.databinding.FragmentNoteBinding
import com.example.cleanarchproject.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class NoteFragment : BaseFragment<FragmentNoteBinding>() {
    override val viewModel by inject<NoteViewModel>()

    override val layoutId: Int = R.layout.fragment_note
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e("NOTE_FRAGMENT")
    }

    companion object {
        fun newInstance() = NoteFragment()
    }
}
