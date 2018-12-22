package com.tqeil.couplesenppai.ui.match

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.databinding.ActivityMatchResultBinding
import net.jspiner.ask.ui.base.BaseActivity
import net.jspiner.ask.ui.base.BaseViewModel

class MatchResultActivity : BaseActivity<ActivityMatchResultBinding, BaseViewModel>() {

    companion object {

        private const val INTENT_KEY_SCHOOL_NAME = "intentKeySchoolName"
        private const val INTENT_KEY_CLASS_NAME = "intentKeyClassName"
        private const val INTENT_KEY_TAG_LIST = "intentKeyTagList"

        fun startActivity(context: Context, schoolName: String, className: String, tagList: ArrayList<String>) {
            Intent(context, MatchResultActivity::class.java).apply {
                putExtra(INTENT_KEY_SCHOOL_NAME, schoolName)
                putExtra(INTENT_KEY_CLASS_NAME, className)
                putExtra(INTENT_KEY_TAG_LIST, tagList)
            }

        }

    }

    override fun getLayoutId() = R.layout.activity_match_result
    override fun createViewModel() = object : BaseViewModel() {}

    private lateinit var schoolName: String
    private lateinit var className: String
    private lateinit var tagList: ArrayList<String>

    override fun loadState(bundle: Bundle) {
        schoolName = bundle.getString(INTENT_KEY_SCHOOL_NAME)
        className = bundle.getString(INTENT_KEY_CLASS_NAME)
        tagList = bundle.getStringArrayList(INTENT_KEY_TAG_LIST)
    }

    override fun saveState(bundle: Bundle) {
        bundle.putString(INTENT_KEY_SCHOOL_NAME, schoolName)
        bundle.putString(INTENT_KEY_CLASS_NAME, className)
        bundle.putStringArrayList(INTENT_KEY_TAG_LIST, tagList)
    }
}