package com.vibe.exatech.Dashboard

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vibe.exatech.utils.Const
import com.vibe.exatech.DrawerActivity
import com.vibe.exatech.R
import kotlinx.android.synthetic.main.fragment_message.view.*
import kotlinx.android.synthetic.main.toolbar.*

class MessageFragment() : Fragment() {

    companion object {

        fun newInstance(fromScreen: Int): MessageFragment {
            val args = Bundle()
            args.putInt(Const.scrTag, fromScreen)
            val fragment = MessageFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)
        view.msgRecycle.adapter = MessageAdapter(context!!)
        val fromScreen = arguments?.getInt(Const.scrTag)
        if (fromScreen != null && fromScreen == Const.scrAttentnTag) {

        } else {
            setToolbar()
        }

        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgBack.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.messagesTitle))

    }

    class MessageAdapter(context: Context) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
        val context = context

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MessageAdapter.ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_message, p0, false))
        }

        override fun getItemCount(): Int {
            return 2
        }

        override fun onBindViewHolder(p0: MessageAdapter.ViewHolder, p1: Int) {
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        }
    }
}