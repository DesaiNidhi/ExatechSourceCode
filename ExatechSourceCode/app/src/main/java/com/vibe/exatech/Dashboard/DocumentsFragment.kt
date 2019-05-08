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
import kotlinx.android.synthetic.main.fragment_inspection.view.*
import kotlinx.android.synthetic.main.toolbar.*

class DocumentsFragment() : Fragment() {

    companion object {

        fun newInstance(fromScreen: Int): DocumentsFragment {
            val args = Bundle()
            args.putInt(Const.scrTag, fromScreen)
            val fragment = DocumentsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_inspection, container, false)
        view.recyclerview.adapter = DocAdapter(context!!)
        view.txtCount.setText("2 Documents")
        val fromScreen = arguments?.getInt(Const.scrTag)
        if (fromScreen != null && fromScreen == Const.scrAttentnTag) {
            view.viewLine.visibility = View.GONE
            view.txtCount.visibility = View.GONE
        }
        else{
            setToolbar()

        }
        return view
    }

    fun setToolbar() {
        (context as DrawerActivity).showToolbarIcons(View.GONE)
        (context as DrawerActivity).toolbar.setBackgroundColor(resources.getColor(android.R.color.white))
        (context as DrawerActivity).imgBack.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.visibility = View.VISIBLE
        (context as DrawerActivity).txtTitle.setText(resources.getString(R.string.documentsTitle))

    }

    class DocAdapter(context: Context) : RecyclerView.Adapter<DocAdapter.ViewHolder>() {
        val context = context
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_documents, p0, false))

        }

        override fun getItemCount(): Int {
            return 2
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        }

    }
}