package com.tqeil.couplesenppai.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.Utils.BottomNavigationHelper
import com.tqeil.couplesenppai.databinding.ActivityMainBinding
import net.jspiner.ask.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(){

    override fun loadState(bundle: Bundle) {
        //no-op
    }

    override fun saveState(bundle: Bundle) {
        //no-op
    }

    override fun createViewModel() = MainViewModel()
    override fun getLayoutId() = R.layout.activity_main

    private lateinit var pagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPager()
        initBottomNavigation()
        intent = Intent(this, LoginaActivity::class.java)
        startActivity(intent)
    }

    private fun initPager() {
        pagerAdapter = MainPagerAdapter(supportFragmentManager)
        binding.pager.adapter = pagerAdapter
        binding.pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                // no-op
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // no-op
            }

            override fun onPageSelected(position: Int) {
                binding.bottomNavigation
                    .menu
                    .getItem(position).isChecked = true
            }

        })
    }

    private fun initBottomNavigation() {
        BottomNavigationHelper.disableShiftMode(binding.bottomNavigation)
        binding.bottomNavigation.setOnNavigationItemSelectedListener { menu->
            val pageIndex = when (menu.itemId) {
                R.id.menu_calendar -> 0
                R.id.menu_match -> 1
                R.id.menu_home -> 2
                R.id.menu_chatting -> 3
                R.id.menu_feed -> 4
                else -> throw IllegalArgumentException("잘못된 id : ${menu.itemId}")
            }
            binding.pager.currentItem = pageIndex

            true
        }
    }
}
