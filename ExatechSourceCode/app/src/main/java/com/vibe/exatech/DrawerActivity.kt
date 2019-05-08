package com.vibe.exatech

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.vibe.exatech.Dashboard.*
import com.vibe.exatech.utils.Const
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.toolbar.*


class DrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    override fun onClick(p0: View?) {
        if (p0?.id == R.id.imgMessage) {
            pushFragment(MessageFragment(), true)
        }
        if (p0?.id == R.id.imgDrawer) {
            drawer_layout.openDrawer(GravityCompat.END)

        }
        if (p0?.id == R.id.imgBack) {
            onBackPressed()
        }
        if (p0?.id == R.id.imgFilter) {
            pushFragment(SearchFilter(), true)
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        if (p0.itemId == R.id.dashboard) {
            pushFragment(DashboardFragment(), false)

        }
        if (p0.itemId == R.id.about) {
            pushFragment(ProfileFragment(), true)
        }
        if (p0.itemId == R.id.myOrders) {
            pushFragment(MyOrdersFragment.newInstance(Const.scrDrawerTag), true)

        }
        if (p0.itemId == R.id.acceptOrders) {
            pushFragment(AcceptOrderFragment(), true)
        }
        if (p0.itemId == R.id.outOfOffice) {
            pushFragment(OutofOfficeFragment(), true)
        }
        if (p0.itemId == R.id.organization) {
            pushFragment(OrganizationFragment(), true)
        }
        if (p0.itemId == R.id.attentionRequired) {
            pushFragment(AttentionRequiredFragment(), true)
        }
        if (p0.itemId == R.id.settings) {
            pushFragment(SettingsFragment(), true)
        }
        if (p0.itemId == R.id.about) {
            pushFragment(AboutusFragment(), true)
        }
        drawer_layout.closeDrawer(GravityCompat.END)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        imgDrawer.setOnClickListener(this)
        imgMessage.setOnClickListener(this)
        toolbar.navigationIcon = null
        navigationView.setNavigationItemSelectedListener(this)
        pushFragment(DashboardFragment(), false)
        showToolbarIcons(View.VISIBLE)
        imgBack.setOnClickListener(this)
        imgFilter.setOnClickListener(this)


    }

    fun showToolbarIcons(VISIBLE: Int) {
        imgDrawer.visibility = VISIBLE
        imgSearch.visibility = VISIBLE
        imgMessage.visibility = VISIBLE
        imgFilter.visibility = VISIBLE
        imgBack.visibility = VISIBLE
        txtMsgCount.visibility = VISIBLE
        imgInspectn.visibility = VISIBLE
        imgDoc.visibility = VISIBLE
        imgMessageDetail.visibility = VISIBLE

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
            drawer_layout.closeDrawer(GravityCompat.END)
        } else {
            super.onBackPressed()
        }
    }

    fun pushFragment(fragment: Fragment, isBackStack: Boolean) {
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(mainLayout.id, fragment, fragment.javaClass.getSimpleName())
        if (isBackStack) {
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        }
        fragmentTransaction.commit()
    }

    override fun onResume() {
        super.onResume()

    }
}