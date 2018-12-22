package com.tqeil.couplesenppai.ui.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.tqeil.couplesenppai.R
import com.tqeil.couplesenppai.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import net.jspiner.ask.ui.base.BaseActivity
import net.jspiner.ask.ui.base.BaseViewModel
import java.lang.IllegalArgumentException

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    override fun loadState(bundle: Bundle) {
        //no-op
    }

    override fun saveState(bundle: Bundle) {
        //no-op
    }

    override fun createViewModel() = MainViewModel()
    override fun getLayoutId() = R.layout.activity_main

    private lateinit var pager: ViewPager
    private lateinit var pagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        initPager()
    }

    private fun initPager() {
        pager = findViewById(R.id.pager)
        pagerAdapter = MainPagerAdapter(supportFragmentManager)
        pager.adapter = pagerAdapter
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val pageIndex = when (item.itemId) {
            R.id.nav_calendar -> 0
            R.id.nav_chat -> 1
            R.id.nav_feed -> 2
            R.id.nav_match -> 3
            else -> throw IllegalArgumentException("잘못된 id : ${item.itemId}")
        }
        pager.currentItem = pageIndex

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
