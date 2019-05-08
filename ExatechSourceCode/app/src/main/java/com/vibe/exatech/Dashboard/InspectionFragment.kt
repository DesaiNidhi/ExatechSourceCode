package com.vibe.exatech.Dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.utils.Const
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_inspection.view.*
import kotlinx.android.synthetic.main.toolbar.*

class InspectionFragment() : Fragment() {

    var isAttention = false

    companion object {

        fun newInstance(fromScreen: Int): InspectionFragment {
            val args = Bundle()
            args.putInt(Const.scrTag, fromScreen)
            val fragment = InspectionFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_inspection, container, false)
        val fromScreen = arguments?.getInt(Const.scrTag)
        if (fromScreen != null && fromScreen == Const.scrAttentnTag) {
            view.txtCount.visibility = View.GONE
            isAttention = true
            view.viewLine.visibility = View.GONE

        } else {
            setToolbar()
        }
        view.recyclerview.adapter = InspectionAdapter(context!!, fromScreen)

        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).imgBack.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.inspection))

    }

    override fun onResume() {
        super.onResume()

    }
}