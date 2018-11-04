package com.rightel.mykotlin.retrofit

import com.rightel.mykotlin.dataModel.DataModelPost
import retrofit2.http.GET
import rx.Observable


interface RestApis {
/**
 * https://jsonplaceholder.typicode.com/posts
 * */

    @get : GET("posts")
    val posts : Observable<List<DataModelPost>>
}