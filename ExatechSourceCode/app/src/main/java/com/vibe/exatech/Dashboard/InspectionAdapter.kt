package com.vibe.exatech.Dashboard

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.utils.Const
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.row_my_orders.view.*

class InspectionAdapter(context: Context, fromScreen: Int?) : RecyclerView.Adapter<InspectionAdapter.ViewHolder>() {
    var context = context
    var fromScreen=fromScreen

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): InspectionAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_my_orders, p0, false))

    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(p0: InspectionAdapter.ViewHolder, p1: Int) {
       p0.imageView.setImageDrawable(context.resources.getDrawable(R.drawable.img_book_appoinment))
       p0.imageView.setColorFilter(context.resources.getColor(R.color.colorPrimary))
       if(fromScreen!=null && fromScreen== Const.scrAttentnTag)
       {
           p0.viewLine.visibility=View.GONE

       }
        p0.imageView.setOnClickListener(View.OnClickListener {
            (context as DrawerActivity).pushFragment(BookAppoinmentFragment(), true)
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardView = view.cardView as CardView
        var imageView = view.imgIcon
        var viewLine=view.view
    }
}