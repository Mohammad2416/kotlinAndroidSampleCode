package com.rightel.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.rightel.mykotlin.adapers.CustomRecyclerViewAdapter
import com.rightel.mykotlin.dataModel.DataModelRecycler
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        activity_recycler_rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)

        val dataModels = ArrayList<DataModelRecycler>()
        dataModels.add(DataModelRecycler("Mohammad", "1988"))
        dataModels.add(DataModelRecycler("Omid", "2010"))
        dataModels.add(DataModelRecycler("Laleh", "2011"))
        dataModels.add(DataModelRecycler("Hasan", "1988"))
        dataModels.add(DataModelRecycler("Narges", "1299"))

        val adapter = CustomRecyclerViewAdapter(dataModels)
        activity_recycler_rv.adapter =  adapter



    }
}
