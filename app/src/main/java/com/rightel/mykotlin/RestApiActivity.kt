package com.rightel.mykotlin
/**
 * Here I'll show how to work with Retrofit2 and Rxjava with Kotlin
 * I'll get information from fake REST API from internet.
 * https://jsonplaceholder.typicode.com/posts
 * */
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.rightel.mykotlin.adapers.CustomRecyclerViewAdapter
import com.rightel.mykotlin.adapers.PostApiRecyclerViewAdapter
import com.rightel.mykotlin.dataModel.DataModelPost
import com.rightel.mykotlin.retrofit.RestApis
import com.rightel.mykotlin.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_rest_api.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RestApiActivity : AppCompatActivity() {

    private lateinit var restApi : RestApis
    private var retrofit: Retrofit? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_api)

        restApi = getRetrofitInstance().create(RestApis::class.java)

        activity_restapi_rv.setHasFixedSize(true)
        activity_restapi_rv.layoutManager = LinearLayoutManager(this)

        fetchData()
    }

    private fun fetchData() {
        restApi.posts.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{posts -> displayData(posts)}

    }


    private fun  getRetrofitInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }

    private fun displayData(posts: List<DataModelPost>?) {
        val adapter = PostApiRecyclerViewAdapter(posts!!)
        activity_restapi_rv.adapter = adapter
    }
}
