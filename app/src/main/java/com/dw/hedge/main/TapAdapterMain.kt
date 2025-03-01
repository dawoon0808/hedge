package com.dw.hedge.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TapAdapterMain(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    private val fragments = listOf(FragmentMain(), FragmentMain(),FragmentMain(),FragmentMain())

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}