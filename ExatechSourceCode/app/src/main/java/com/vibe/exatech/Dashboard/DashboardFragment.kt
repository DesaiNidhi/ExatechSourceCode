package com.vibe.exatech.Dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.toolbar.*

class DashboardFragment : Fragment(), View.OnClickListener {
    internal lateinit var view:View
    override fun onClick(p0: View?) {
        if (p0?.id == R.id.imgProfile) {
            (context as DrawerActivity).pushFragment(ProfileFragment(), false)
        }
        if(p0?.id==R.id.toggleOut)
        {
            if(view?.toggleOut?.isChecked!!)
            {
                (context as DrawerActivity).pushFragment(OutofOfficeFragment(), true)

            }

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        view.recycleview.adapter = DashboardAdapter(context)
        view.imgProfile.setOnClickListener(this)
        view.toggleOut.setOnClickListener(this)
        setToolbar()


        return view
    }

    override fun onResume() {
        super.onResume()
        setToolbar()
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.VISIBLE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        (context as DrawerActivity).imgFilter.visibility = View.VISIBLE
        (context as DrawerActivity).imgFilter.setImageDrawable(resources.getDrawable(R.drawable.img_filter))
        (context as DrawerActivity).imgDrawer.visibility = View.VISIBLE
        (context as DrawerActivity).imgDoc.visibility = View.GONE
        (context as DrawerActivity).imgInspectn.visibility = View.GONE
        (context as DrawerActivity).imgMessageDetail.visibility = View.GONE
        (context as DrawerActivity).imgDrawer.setColorFilter(resources.getColor(android.R.color.white))
        (context as DrawerActivity).txtTitle.visibility = View.GONE
        (context as DrawerActivity).txtMsgCount.visibility = View.VISIBLE

    }
}