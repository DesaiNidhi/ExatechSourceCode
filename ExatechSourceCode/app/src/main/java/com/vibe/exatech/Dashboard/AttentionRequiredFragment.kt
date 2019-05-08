package com.vibe.exatech.Dashboard

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.vibe.exatech.utils.Const
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_my_order.view.*
import kotlinx.android.synthetic.main.toolbar.*

class AttentionRequiredFragment() : Fragment(), TabLayout.OnTabSelectedListener {
    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
    }

    internal lateinit var view: View
    internal lateinit var pagerAdapter: Pager
    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgDrawer.visibility = View.VISIBLE
        (context as DrawerActivity).imgDrawer.setColorFilter(resources.getColor(R.color.colorPrimary))
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.attentionRequired))

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.fragment_my_order, container, false)
        pagerAdapter = Pager(this.childFragmentManager!!, context!!)
        setToolbar()
        setUpViewPager()
        setupTabs()
        view.orderCount.visibility=View.GONE
        return view
    }

    fun setUpViewPager() {
        view.pager.adapter = pagerAdapter


    }

    fun setupTabs() {
        view.tabLayout.setupWithViewPager(view.pager)
        view.tabLayout.addOnTabSelectedListener(this)
        for (i in 0 until view.tabLayout.tabCount) {
            val tab = view.tabLayout.getTabAt(i)
            tab?.setCustomView(pagerAdapter.getTabView(i))
        }

    }

    class Pager(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {
        val context = context
        override fun getItem(p0: Int): Fragment? {
            when (p0) {
                0 -> {
                    return InspectionFragment.newInstance(Const.scrAttentnTag)
                }
                1 -> {
                    return MessageFragment.newInstance(Const.scrAttentnTag)
                }
                2 -> {
                    return DocumentsFragment.newInstance(Const.scrAttentnTag)
                }
                else -> return null
            }
        }


        override fun getCount(): Int {
            return 3
        }


        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun getTabView(position: Int): View {
            // Given you have a custom layout in `res/layout/custom_tab.fileprovider` with a TextView and ImageView
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_layout, null)
            val tabText = tabView.findViewById(R.id.tabText) as TextView
            val tabIcon = tabView.findViewById(R.id.tabIcon) as ImageView
            tabIcon.visibility = View.GONE
            when (position) {
                0 -> {
                    tabText.setText(context.resources.getString(R.string.inspections))

                }
                1 -> {
                    tabText.setText(context.resources.getString(R.string.messages))
                }
                2 -> {
                    tabText.setText(context.resources.getString(R.string.documents))
                }
            }


            return tabView
        }


    }

}