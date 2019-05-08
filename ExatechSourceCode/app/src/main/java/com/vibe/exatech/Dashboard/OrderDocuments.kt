package com.vibe.exatech.Dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.row_my_orders.view.*
import kotlinx.android.synthetic.main.toolbar.*

class OrderDocuments() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_order_documents, container, false)
        view.view.visibility = View.GONE
        view.imgIcon.visibility = View.GONE
        setToolbar()
        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgBack.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.orderDocTitle))

    }
}