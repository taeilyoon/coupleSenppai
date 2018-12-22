package com.tqeil.couplesenppai

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.lang.IllegalArgumentException

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        const val PAGE_COUNT = 4
    }

    override fun getCount() = PAGE_COUNT

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> CalendarFragment.create()
            1 -> ChatFragment.create()
            2 -> FeedFragment.create()
            3 -> MatchFragment.create()
            else -> throw IllegalArgumentException("올바르지 못한 position : $position")
        }
    }

}