package com.vibe.exatech.Dashboard

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.utils.Const
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.row_dashboard.view.*

class DashboardAdapter(val context: Context?) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {
    var dashboardItems = context?.resources?.getStringArray(R.array.dashboardItems)
    var dashboardIcons = arrayOf<Int>(
        R.drawable.img_late_order_active,
        R.drawable.img_inspections,
        R.drawable.img_open_orders_active,
        R.drawable.img_accept,
        R.drawable.img_documents,
        R.drawable.img_revise_orders_active
    )

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): DashboardViewHolder {
        return DashboardViewHolder(LayoutInflater.from(context).inflate(R.layout.row_dashboard, p0, false))
    }

    override fun getItemCount(): Int {
        return dashboardItems!!.size
    }

    override fun onBindViewHolder(p0: DashboardViewHolder, p1: Int) {
        p0.txtDashboardItem.setText(dashboardItems?.get(p1))
        p0.imgDashboardIcon.setImageDrawable(context?.resources?.getDrawable(dashboardIcons.get(p1)))
        var myOrederfragment: MyOrdersFragment
        p0.cardView.setOnClickListener(View.OnClickListener {
            when (p1) {
                0 -> {
                    myOrederfragment = MyOrdersFragment.newInstance(Const.lateTag)
                    (context as DrawerActivity).pushFragment(myOrederfragment, true)
                }
                1 -> {
                    (context as DrawerActivity).pushFragment(InspectionFragment(), true)
                }
                2 -> {
                    myOrederfragment = MyOrdersFragment.newInstance(Const.openTag)
                    (context as DrawerActivity).pushFragment(myOrederfragment, true)
                }
                3 ->
                {
                    (context as DrawerActivity).pushFragment(AcceptOrderFragment(), true)

                }
                4 ->
                {
                    (context as DrawerActivity).pushFragment(DocumentsFragment(), true)

                }
                5 -> {
                    myOrederfragment = MyOrdersFragment.newInstance(Const.revisedTag)
                    (context as DrawerActivity).pushFragment(myOrederfragment, true)
                }

            }
        })

    }

    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtDashboardItem = view.txtdashboardItem
        val imgDashboardIcon = view.imgDashboardIcon
        val cardView = view.cardView
    }

}