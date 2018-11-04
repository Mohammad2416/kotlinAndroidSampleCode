package com.rightel.mykotlin
/**
 * Here I'll show how to work with Retrofit2 and Rxjava with Kotlin
 * I'll get information from fake REST API from internet.
 * https://jsonplaceholder.typicode.com/posts
 * */
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class RestApiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest_api)
    }
}
