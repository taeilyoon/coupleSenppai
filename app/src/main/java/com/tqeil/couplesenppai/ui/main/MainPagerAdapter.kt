package com.tqeil.couplesenppai.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.tqeil.couplesenppai.ui.main.fragment.*
import java.lang.IllegalArgumentException

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        const val PAGE_COUNT = 4
    }

    override fun getCount() = PAGE_COUNT

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> CalendarFragment.create()
            1 -> MatchFragment.create()
            2 -> HomeFragment.create()
            3 -> ChatFragment.create()
            4 -> FeedFragment.create()
            else -> throw IllegalArgumentException("올바르지 못한 position : $position")
        }
    }

}