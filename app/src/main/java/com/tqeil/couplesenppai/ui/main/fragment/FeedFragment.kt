package com.tqeil.couplesenppai.ui.main.fragment

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tqeil.couplesenppai.R

class FeedFragment: Fragment() {

    companion object {

        fun create(): FeedFragment {
            val fragment = FeedFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_feed, container, false)

        return rootView
    }
}