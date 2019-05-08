package com.vibe.exatech.Dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_out_of_office.view.*
import kotlinx.android.synthetic.main.toolbar.*

class OutofOfficeFragment : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        if (p0?.id == R.id.txtCancel) {
            (context as DrawerActivity).onBackPressed()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_out_of_office, container, false)
        setToolbar()
        view.txtCancel.setOnClickListener(this)
        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgDrawer.visibility = View.VISIBLE
        (context as DrawerActivity).imgDrawer.setColorFilter(resources.getColor(R.color.colorPrimary))
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.outOfOfiice))

    }
}