package com.vibe.exatech.Dashboard

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.text.TextUtils
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


class MyOrdersFragment() : Fragment(), TabLayout.OnTabSelectedListener {
    internal lateinit var view: View
    internal lateinit var pagerAdapter: Pager

    companion object {

        fun newInstance(selectedTabName: String): MyOrdersFragment {
            val args = Bundle()
            args.putString("name", selectedTabName)
            val fragment = MyOrdersFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.fragment_my_order, container, false)
        pagerAdapter = Pager(this.childFragmentManager!!, context!!)
        val selectedTabName = arguments?.getString("name")
        setUpViewPager()
        setupTabs()
        if(!TextUtils.isEmpty(selectedTabName))
   {
                if(selectedTabName!!.equals(Const.openTag))
                {
                    view.tabLayout.getTabAt(0)!!.select()
                }
                else  if(selectedTabName!!.equals(Const.lateTag))
                {
                    view.tabLayout.getTabAt(1)!!.select()

                }
                else if(selectedTabName!!.equals(Const.revisedTag))
                {
                    view.tabLayout.getTabAt(2)!!.select()
                }
       if(selectedTabName!!.equals(Const.scrDrawerTag))
       {
           setToolbar(true)
       }
       else
       {
           setToolbar(false)
       }
   }

        return view
    }
 fun setToolbar(isDrawer: Boolean)
 {
     (context as DrawerActivity).showToolbarIcons(View.GONE)
     (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
     if(isDrawer)
     {
         (context as DrawerActivity).imgDrawer.visibility=View.VISIBLE
         (context as DrawerActivity).imgDrawer.setColorFilter(resources.getColor(R.color.colorPrimary))
         (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.myOrders))

     }
     else
     {
         (context as DrawerActivity).imgBack.visibility=View.VISIBLE
         (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.orderList))


     }
     (context as DrawerActivity).txtTitle.visibility=View.VISIBLE

 }
    fun setupTabs() {
        view.tabLayout.setupWithViewPager(view.pager)
        view.tabLayout.addOnTabSelectedListener(this)
        for (i in 0 until view.tabLayout.tabCount) {
            val tab = view.tabLayout.getTabAt(i)
            tab?.setCustomView(pagerAdapter.getTabView(i))

        }
        view.tabLayout.getTabAt(view.tabLayout.selectedTabPosition)?.customView?.findViewById<TextView>(R.id.tabText)?.setTextColor(resources.getColor(R.color.colorPrimary))
        view.tabLayout.getTabAt(view.tabLayout.selectedTabPosition)?.customView?.findViewById<ImageView>(R.id.tabIcon)?.setColorFilter(resources.getColor(R.color.colorPrimary))

    }

    fun setUpViewPager() {
        view.pager.adapter = pagerAdapter


    }

    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
        p0?.customView?.findViewById<TextView>(R.id.tabText)?.setTextColor(Color.BLACK)
        p0?.customView?.findViewById<ImageView>(R.id.tabIcon)?.setColorFilter(Color.BLACK)

    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        view.pager.setCurrentItem(p0!!.position)
        view.tabLayout.setSelectedTabIndicatorColor(resources.getColor(R.color.colorPrimary))
        p0.customView?.findViewById<TextView>(R.id.tabText)?.setTextColor(resources.getColor(R.color.colorPrimary))
        p0.customView?.findViewById<ImageView>(R.id.tabIcon)?.setColorFilter(resources.getColor(R.color.colorPrimary))

    }

    override fun onResume() {
        super.onResume()

    }
    class Pager(fm: FragmentManager, context: Context) : FragmentPagerAdapter(fm) {
        val context = context
        override fun getItem(p0: Int): Fragment? {
            when (p0) {
                0 -> {
                    return OpenOrderFragment()
                }
                1 -> {
                    return LateOrderFragment()
                }
                2 -> {
                    return RevisedOrderFragment()
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
            val tabImg = tabView.findViewById(R.id.tabIcon) as ImageView
            when (position) {
                0 -> {
                    tabText.setText(context.resources.getString(R.string.openOrder))
                    tabImg.setImageDrawable(context.resources.getDrawable(R.drawable.img_open_orders_active))

                }
                1 -> {
                    tabText.setText(context.resources.getString(R.string.lateOrder))
                    tabImg.setImageDrawable(context.resources.getDrawable(R.drawable.img_late_order_active))
                }
                2 -> {
                    tabText.setText(context.resources.getString(R.string.revisedOrder))
                    tabImg.setImageDrawable(context.resources.getDrawable(R.drawable.img_revise_orders_active))
                }
            }


            return tabView
        }


    }


}