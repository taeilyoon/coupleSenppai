package com.tqeil.couplesenppai.ui.main.fragment

import android.databinding.ViewDataBinding
import android.os.Bundle
import com.tqeil.couplesenppai.R
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.ask.ui.base.BaseViewModel

class CalendarFragment: BaseFragment<ViewDataBinding, BaseViewModel>() {

    override fun getLayoutId() = R.layout.fragment_calendar

    companion object {

        fun create(): CalendarFragment {
            val fragment = CalendarFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

}