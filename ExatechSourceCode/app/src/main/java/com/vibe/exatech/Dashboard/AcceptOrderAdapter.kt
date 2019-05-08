package com.vibe.exatech.Dashboard

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.row_my_orders.view.*

class AcceptOrderAdapter(context: Context) : RecyclerView.Adapter<AcceptOrderAdapter.ViewHolder>() {
    var context = context
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_my_orders, p0, false))
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

            p0.checkBox.visibility = View.VISIBLE
        p0.txtOrderCode.visibility = View.GONE
        p0.imgIcon.setImageDrawable(context.resources.getDrawable(R.drawable.img_pdf))
        p0.imgIcon.setColorFilter(context.resources.getColor(R.color.colorPrimary))
        p0.checkBox.setOnClickListener(View.OnClickListener {
            if (p0.checkBox.getTag().equals("0")) {
                p0.checkBox.setTag("1")
                p0.checkBox.setImageDrawable(context.resources.getDrawable(R.drawable.img_select))
                p0.checkBox.setColorFilter(context.resources.getColor(R.color.colorPrimary))
            } else {
                p0.checkBox.setTag("0")
                p0.checkBox.setImageDrawable(context.resources.getDrawable(R.drawable.img_unselect))
                p0.checkBox.setColorFilter(context.resources.getColor(R.color.colorPrimary))

            }
        }
        )
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val checkBox = view.imgCheckbox as ImageView
        val txtOrderCode = view.txtOrderCode as TextView
        val imgIcon = view.imgIcon as ImageView
    }

}