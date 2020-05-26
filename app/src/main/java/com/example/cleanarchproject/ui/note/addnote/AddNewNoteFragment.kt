package com.example.cleanarchproject.ui.note.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.cleanarchproject.R
import com.example.cleanarchproject.databinding.FragmentAddNewNoteBinding
import com.example.cleanarchproject.ui.base.BaseFragment
import com.example.cleanarchproject.ui.base.BaseViewModel
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class AddNewNoteFragment : BaseFragment<FragmentAddNewNoteBinding>() {
    override val viewModel by inject<AddNewNoteViewModel>()
    override val layoutId: Int = R.layout.fragment_add_new_note

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance() = AddNewNoteFragment()
    }

}
