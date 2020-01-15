package com.example.shamed.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class AvatarPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    val SIZE = 3
    var avatars = arrayListOf<Avatar>()

    override fun getItem(position: Int): Fragment {
        return when(position){
            1 -> AnimalOneFragment.newInstance()
            2 -> AnimalTwoFragment.newInstance()
            3 -> AnimalThreeFragment.newInstance()
            else -> AnimalOneFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return SIZE
    }

}