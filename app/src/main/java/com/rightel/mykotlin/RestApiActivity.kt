package com.rightel.mykotlin
/**
 * Here I'll show how to work with Retrofit2 and Rxjava with Kotlin
 * I'll get information from fake REST API from internet.
 * https://jsonplaceholder.typicode.com/posts
 * */
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.rightel.mykotlin.adapers.PostApiRecyclerViewAdapter
import com.rightel.mykotlin.dataModel.DataModelPost
import com.rightel.mykotlin.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_rest_api.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RestApiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_api)

        activity_restapi_rv.setHasFixedSize(true)
        activity_restapi_rv.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    private fun fetchData() {
        RetrofitClient.getService().posts
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{posts -> displayData(posts)}
    }

    private fun displayData(posts: List<DataModelPost>?) {
        val adapter = PostApiRecyclerViewAdapter(posts!!)
        activity_restapi_rv.adapter = adapter
    }
}
