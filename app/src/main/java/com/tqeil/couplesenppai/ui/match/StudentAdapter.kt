package com.tqeil.couplesenppai.ui.match

import android.databinding.ViewDataBinding
import android.view.ViewGroup
import net.jspiner.ask.ui.base.BaseAdapter
import net.jspiner.ask.ui.base.BaseViewHolder

class StudentAdapter: BaseAdapter<String>() {

    override fun onCreateViewHolderInternal(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<out ViewDataBinding, String> {
        return StudentViewHolder(parent)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding, String>, position: Int) {
        //no-op
    }

}