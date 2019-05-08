package com.vibe.exatech.Dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_open_order.view.*

class LateOrderFragment:Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_open_order,container,false)
        view.recycleView.adapter=OpenOrderAdapter(context!!)

        return view
    }
}