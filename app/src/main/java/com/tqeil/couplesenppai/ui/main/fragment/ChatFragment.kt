package com.tqeil.couplesenppai.ui.main.fragment

import android.os.Bundle
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.databinding.FragmentChatBinding
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.ask.ui.base.BaseViewModel

class ChatFragment: BaseFragment<FragmentChatBinding, BaseViewModel>() {

    override fun getLayoutId() = R.layout.fragment_chat

    companion object {

        fun create(): ChatFragment {
            val fragment = ChatFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

}