package com.tqeil.couplesenppai

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        const val PAGE_COUNT = 4
    }

    override fun getCount() = PAGE_COUNT

    override fun getItem(position: Int): Fragment {
        TODO("not implemented")
    }

}