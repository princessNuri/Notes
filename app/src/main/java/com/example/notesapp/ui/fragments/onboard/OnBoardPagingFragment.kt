package com.example.notesapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding : FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentOnBoardPagingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding){
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0->{
                tvOnboard.text="Очень удобный функционал"
                ivOnboard.setAnimation(R.raw.anim)
            }
            1->{
                tvOnboard.text="Быстрый, качественный продукт"
                ivOnboard.setAnimation(R.raw.animation)
            }
            2->{
                tvOnboard.text="Куча функций и интересных фишек"
                ivOnboard.setAnimation(R.raw.animat)
            }

            else -> {}
        }

    }

    companion object {
        const val ARG_ONBOARD_POSITION="onBoard"
    }

}