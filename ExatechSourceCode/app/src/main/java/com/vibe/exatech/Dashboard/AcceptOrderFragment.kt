package com.vibe.exatech.Dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_accept_order.view.*
import kotlinx.android.synthetic.main.toolbar.*

class AcceptOrderFragment():Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_accept_order,container,false)
        view.recyclerview.adapter=AcceptOrderAdapter(context!!)
       setToolbar()
        return view
    }
    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgBack.visibility = View.VISIBLE
        (context as DrawerActivity).imgDrawer.visibility=View.VISIBLE
        (context as DrawerActivity).imgDrawer.setColorFilter(resources.getColor(R.color.colorPrimary))
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.acceptOrder))

    }
}