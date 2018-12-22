package com.tqeil.couplesenppai.ui.main.fragment

import android.os.Bundle
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.databinding.FragmentFeedBinding
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.ask.ui.base.BaseViewModel

class FeedFragment: BaseFragment<FragmentFeedBinding, BaseViewModel>() {

    override fun getLayoutId() = R.layout.fragment_feed

    companion object {

        fun create(): FeedFragment {
            val fragment = FeedFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

}