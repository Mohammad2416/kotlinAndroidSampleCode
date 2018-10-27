package com.rightel.mykotlin.adapers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rightel.mykotlin.R
import com.rightel.mykotlin.dataModel.DataModelRecycler
import kotlinx.android.synthetic.main.row_recycler.view.*

class CustomRecyclerViewAdapter(var listModel : ArrayList<DataModelRecycler>) : RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.row_recycler, p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listModel.size
    }

    override fun onBindViewHolder(vh: ViewHolder, index: Int) {

       val dataModel : DataModelRecycler = listModel[index]
       
       vh.txtTitle.text = dataModel.name
       vh.txtDate.text = dataModel.date
    }


    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.row_recycler_txt_title!!
        val txtDate = itemView.row_recycler_txt_date!!
    }

}