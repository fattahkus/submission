package com.fatkus.submission

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fatkus.submission.fragment.ListFragment
import com.fatkus.submission.MainActivity
import com.fatkus.submission.adapter.GridProductAdapter
import com.fatkus.submission.adapter.ListProductAdapter
import com.fatkus.submission.fragment.CardFragment
import com.fatkus.submission.fragment.GridFragment
import com.google.android.material.tabs.TabLayout

class MyPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){
  //  sebuah list yang menampung objek Fragment
    private val pages = listOf(
        ListFragment(),
      GridFragment(),
      CardFragment()
    )
//    private fun setMode(selectedMode: TabLayout.Mode){
//        when(selectedMode){
//            R.layout.fragment_list -> {
//
//            }
//        }
//    }

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