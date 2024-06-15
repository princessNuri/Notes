package com.example.notesapp.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.notesapp.R
import com.example.notesapp.data.models.User
import com.example.notesapp.databinding.FragmentNoteBinding
import com.example.notesapp.utils.SharedPreference

class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() = with (binding) {

        val sharedPreference = SharedPreference()
        sharedPreference.unit(requireContext())

        btnSave.setOnClickListener {
            val et = etTitle.text.toString()
            sharedPreference.title=et
            tvSave.text=et
        }
        tvSave.text=sharedPreference.title

        btnAction.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment,null
//                navOptions {
//                    anim {
//                        enter = R.anim.slide_in_right
//                        exit = R.anim.slide_in_left
//                        popEnter = R.anim.slide_in_left
//                        popExit = R.anim.slide_out_right
//                    }
//                }
            )
        }

    }

//    private fun setUpListener() {
//        binding.btnWeiter.setOnClickListener {
//            findNavController().navigate(
//                MainFragmentDirections.actionMainFragmentToSecondFragment(
//                    User(binding.etName.text.toString(),
//                        binding.etEmail.text.toString(),
//                        binding.etPassword.text.toString().toInt())
//                    )
//            )
//        }
//    }

}