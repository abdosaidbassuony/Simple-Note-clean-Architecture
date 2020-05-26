package com.example.cleanarchproject.ui.note.editnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cleanarchproject.R
import com.example.cleanarchproject.databinding.FragmentEditNoteBinding
import com.example.cleanarchproject.ui.base.BaseFragment
import com.example.cleanarchproject.ui.base.BaseViewModel
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class EditNoteFragment : BaseFragment<FragmentEditNoteBinding>() {
    override val viewModel by inject<EditNoteViewModel>()
    override val layoutId: Int =R.layout.fragment_edit_note

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object{
        fun newInstance() = EditNoteFragment.apply {

        }
    }

}
