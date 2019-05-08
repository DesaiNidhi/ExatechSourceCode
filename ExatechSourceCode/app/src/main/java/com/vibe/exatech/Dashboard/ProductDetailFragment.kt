package com.vibe.exatech.Dashboard

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_product_detail.view.*
import kotlinx.android.synthetic.main.toolbar.*

class ProductDetailFragment : Fragment(),View.OnClickListener {
    override fun onClick(p0: View?) {
        if(p0?.id==R.id.productDetail)
        {
            (context as DrawerActivity).pushFragment(OrderDocuments(),true)
        }
        if(p0?.id==R.id.imgMessageDetail)
        {
            (context as DrawerActivity).pushFragment(MessageFragment(),true)

        }
        if(p0?.id==R.id.imgInspectn)
        {
            (context as DrawerActivity).pushFragment(BookAppoinmentFragment(),true)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_product_detail, container, false)
        view.productDetail.setOnClickListener(this)
        setToolbar()
        (context as DrawerActivity).imgMessageDetail.setOnClickListener(this)
        (context as DrawerActivity).imgInspectn.setOnClickListener(this)


        return view
    }
    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgBack.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).imgDoc.visibility = View.VISIBLE
        (context as DrawerActivity).imgInspectn.visibility = View.VISIBLE
        (context as DrawerActivity).imgMessageDetail.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.orderTitle))

    }
}