package com.vibe.exatech.Dashboard

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.Login.AccesscodeActivity
import com.vibe.exatech.R
import com.vibe.exatech.utils.Const
import kotlinx.android.synthetic.main.fragment_settings.view.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingsFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        view.cardChangeAccessCde.setOnClickListener(View.OnClickListener {
            startActivity(Intent(context, AccesscodeActivity::class.java).putExtra(Const.scrTag,Const.scrSettingsTag))
            activity?.overridePendingTransition(R.anim.slide_up, R.anim.no_change);

        })
        setToolbar()
        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgDrawer.visibility = View.VISIBLE
        (context as DrawerActivity).imgDrawer.setColorFilter(resources.getColor(R.color.colorPrimary))
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.settingsTitle))

    }
}