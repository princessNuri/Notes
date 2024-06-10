package com.example.notesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.notesapp.R
import com.example.notesapp.data.models.User
import com.example.notesapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
    }

    private fun setUpListener() {
        binding.btnWeiter.setOnClickListener {
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToSecondFragment(
                    User(binding.etName.text.toString(),
                        binding.etEmail.text.toString(),
                        binding.etPassword.text.toString().toInt())
                    )
            )
        }
    }

}