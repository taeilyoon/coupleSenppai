package com.tqeil.couplesenppai.ui.main.fragment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.databinding.FragmentMatchBinding
import com.tqeil.couplesenppai.ui.match.MatchResultActivity
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.ask.ui.base.BaseViewModel

class MatchFragment : BaseFragment<FragmentMatchBinding, BaseViewModel>() {

    override fun getLayoutId() = R.layout.fragment_match
    private val selectedTagSet = HashSet<String>()

    companion object {

        fun create(): MatchFragment {
            val fragment = MatchFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tagDisplay.setOnClickListener {
            val popupMenu = PopupMenu(context, binding.tagDisplay)
            listOf(
                "#시각디자인",
                "#3D 모델링",
                "#패션디자인",
                "#웹 퍼블리싱",
                "#수능공부",
                "#내신관리",
                "#유니티 게임 개발"
            ).forEach { title ->
                popupMenu.menu.add(title)
                    .setActionView(R.layout.card_checkbox).apply {
                        isCheckable = true
                        isChecked = selectedTagSet.contains(title)
                    }
                    .isCheckable = true
            }

            popupMenu.setOnMenuItemClickListener { item ->
                println(item.title)
                println(item.isChecked)
                item.isChecked = !item.isChecked
                item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW)
                item.setOnActionExpandListener(object: MenuItem.OnActionExpandListener {
                    override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                        return false
                    }

                    override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                        return false
                    }

                })

                if (item.isChecked) {
                    selectedTagSet.add(item.title.toString())
                }
                else {
                    selectedTagSet.remove(item.title.toString())
                }
                updateTag()
                false
            }
            popupMenu.show()
        }
        binding.search.setOnClickListener {
            MatchResultActivity.startActivity(
                binding.schoolName.toString(),
                binding.className.toString(),
                selectedTagSet.toList()
            )
        }
    }

    private fun updateTag() {
        if (selectedTagSet.size == 0) {
            binding.tagDisplay.text = "태그를 선택해주세요 (중복 가능)"
        }
        else {
            binding.tagDisplay.text = selectedTagSet.joinToString(", ")
        }
    }
}