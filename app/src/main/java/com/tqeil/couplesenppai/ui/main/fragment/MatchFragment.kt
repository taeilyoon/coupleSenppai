package com.tqeil.couplesenppai.ui.main.fragment

import android.os.Bundle
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.databinding.FragmentMatchBinding
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.ask.ui.base.BaseViewModel

class MatchFragment: BaseFragment<FragmentMatchBinding, BaseViewModel>() {

    override fun getLayoutId() = R.layout.fragment_match

    companion object {

        fun create(): MatchFragment {
            val fragment = MatchFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

}