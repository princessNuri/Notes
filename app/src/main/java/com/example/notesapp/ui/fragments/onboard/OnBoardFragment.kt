package com.example.notesapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentOnBoardBinding
import com.example.notesapp.ui.adapters.OnBoardViewPagerAdapter

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding= FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() {
        binding.viewPager.adapter=OnBoardViewPagerAdapter(this@OnBoardFragment)
        binding.dotsIndicator.attachTo(binding.viewPager)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object:
            OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })
    }
    private fun setupListener() = with(binding.viewPager){
        registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                if(position==2){
                    binding.tvOnboardSkip.visibility=View.INVISIBLE
                    binding.tvOnboardStart.visibility=View.VISIBLE
                    binding.tvOnboardStart.setOnClickListener {
                        findNavController().navigate(
                            OnBoardFragmentDirections.actionOnBoardFragmentToNoteFragment()
                        )
                    }
                }else{
                    binding.tvOnboardSkip.visibility=View.VISIBLE
                    binding.tvOnboardStart.visibility=View.INVISIBLE
                    binding.tvOnboardSkip.setOnClickListener {
                        setCurrentItem(currentItem+2,true)
                    }
                }
            }
        })
//        binding.tvOnboardSkip.setOnClickListener {
//            if(currentItem<3){
//                setCurrentItem(currentItem+2,true)
//            }
//        }
    }



}