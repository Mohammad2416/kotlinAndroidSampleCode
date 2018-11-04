package com.rightel.mykotlin.dataModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class DataModelPost{

     @SerializedName("userId")
     @Expose
     private val userId: Int = 0

     @SerializedName("id")
     @Expose
     private val id: Int = 0

     @SerializedName("title")
     @Expose
     private val title: String? = null

     @SerializedName("body")
     @Expose
     private val body: String? = null

 }