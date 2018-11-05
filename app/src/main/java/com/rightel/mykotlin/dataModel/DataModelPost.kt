package com.rightel.mykotlin.dataModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class DataModelPost{

     @SerializedName("userId")
     @Expose
      val userId: Int = 0

     @SerializedName("id")
     @Expose
      val id: Int = 0

     @SerializedName("title")
     @Expose
      val title: String? = null

     @SerializedName("body")
     @Expose
      val body: String? = null

 }