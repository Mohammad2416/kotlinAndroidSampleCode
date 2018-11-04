package com.rightel.mykotlin.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var getInstanceOfRetrofit : Retrofit? = null

    val instance : Retrofit get() {
        if(getInstanceOfRetrofit == null){
            getInstanceOfRetrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build()
        }
        return getInstanceOfRetrofit!!
    }


}