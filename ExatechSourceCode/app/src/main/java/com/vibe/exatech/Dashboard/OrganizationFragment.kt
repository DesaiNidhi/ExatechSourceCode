package com.vibe.exatech.Dashboard

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_organization.view.*
import kotlinx.android.synthetic.main.toolbar.*

class OrganizationFragment() : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_organization, container, false)
        view.recyclerview.adapter = OrganizationAdapter(context!!)
        setToolbar()
        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgDrawer.visibility = View.VISIBLE
        (context as DrawerActivity).imgDrawer.setColorFilter(resources.getColor(R.color.colorPrimary))
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.organizations))

    }

    class OrganizationAdapter(context: Context) : RecyclerView.Adapter<OrganizationAdapter.ViewHolder>() {
        val context = context
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_organization, p0, false))

        }

        override fun getItemCount(): Int {
            return 1
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }

    }
}