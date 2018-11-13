package com.rightel.mykotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import com.rightel.mykotlin.helper.PreferenceHelper
import com.rightel.mykotlin.helper.PreferenceHelper.defaultPrefs

class sharePreferencesActivity : AppCompatActivity() {

    private val TAG : String = "sharePreferences"
    val sharePreferences = getSharedPreferences("share", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_preferences)

        //get default prefs
//        val prefs = PreferenceHelper.defaultPrefs(this)
//
//        //set any type of value in prefs
//        prefs[""] = "name"
//
//        //get any value from prefs
//        val name: String? = prefs["name"]
//
//        //get value from prefs (with default value)
//        val age: Int? = prefs[Constants.PREF_AGE, 23]
//
//        Log.d(TAG,"name : $name")
//        Log.d(TAG,"age : $age")

    }

}
