package com.app.durdling.azkar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CounterViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = DataSet.listOfAzkar.count()

    override fun createFragment(position: Int): Fragment =
        CounterFragment.createInstance(position, DataSet.listOfAzkar[position].text)
}