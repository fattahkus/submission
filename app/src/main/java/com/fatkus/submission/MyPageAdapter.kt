package com.fatkus.submission

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fatkus.submission.fragment.ListFragment
import com.fatkus.submission.fragment.CardFragment
import com.fatkus.submission.fragment.GridFragment

class MyPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    // sebuah list yang menampung objek Fragment
    private val pages = listOf(
        ListFragment(),
        ListFragment(),
        ListFragment()
//        GridFragment(),
//        CardFragment()
    )

    // menentukan fragment yang akan dibuka pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    // judul untuk tabs
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "list view"
            1 -> "grid view"
            else -> "card view"
        }
    }
}