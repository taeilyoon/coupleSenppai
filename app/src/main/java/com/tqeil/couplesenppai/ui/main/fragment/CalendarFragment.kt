package com.tqeil.couplesenppai.ui.main.fragment

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.View
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.databinding.FragmentCalendarBinding
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.ask.ui.base.BaseViewModel

class CalendarFragment: BaseFragment<FragmentCalendarBinding, BaseViewModel>() {

    override fun getLayoutId() = R.layout.fragment_calendar

    companion object {

        fun create(): CalendarFragment {
            val fragment = CalendarFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calenderEvent.initCalderItemClickCallback {
            println("item callback")
            println("${it.year} ${it.month} ${it.day}")
        }
    }
}