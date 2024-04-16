package com.bachir.sportsnewsandinformationapp

import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(
    fragmentActivity: FragmentActivity,
    private var listOfFragments: MutableList<Fragment>,
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return listOfFragments.size
    }

    override fun createFragment(position: Int): Fragment {
      return listOfFragments[position]
    }
}
