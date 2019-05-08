package com.vibe.exatech.Dashboard

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.row_my_orders.view.*

class OpenOrderAdapter(context: Context) : RecyclerView.Adapter<OpenOrderAdapter.ViewHolder>() {
    var context = context
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return OpenOrderAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_my_orders, p0, false))
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.cardView.setOnClickListener(View.OnClickListener
        {
            (context as DrawerActivity).pushFragment(ProductDetailFragment(),true)
        })
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cardView = view.cardView as CardView
    }

}