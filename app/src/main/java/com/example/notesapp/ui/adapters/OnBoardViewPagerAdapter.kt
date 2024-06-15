package com.example.notesapp.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.notesapp.databinding.FragmentOnBoardPagingBinding
import com.example.notesapp.ui.fragments.onboard.OnBoardPagingFragment
import com.example.notesapp.ui.fragments.onboard.OnBoardPagingFragment.Companion.ARG_ONBOARD_POSITION

class OnBoardViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int)= OnBoardPagingFragment().apply {
        arguments= Bundle().apply {
            putInt(ARG_ONBOARD_POSITION,position)
        }
    }
}