package com.rightel.mykotlin.adapers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rightel.mykotlin.R
import com.rightel.mykotlin.dataModel.DataModelPost
import kotlinx.android.synthetic.main.row_rest_api_recyclerview.view.*

class PostApiRecyclerViewAdapter(var listModel: List<DataModelPost>)
     : RecyclerView.Adapter<PostApiRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.row_rest_api_recyclerview, p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listModel.size
    }

    override fun onBindViewHolder(vh: ViewHolder, index: Int) {
        val dataModel : DataModelPost = listModel[index]

        vh.txtTitle.text = dataModel.title.toString()
        vh.txtBody.text = dataModel.body.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.row_recycler_restapi_txt_title
        val txtBody = itemView.row_recycler_restapi_txt_body
    }
}