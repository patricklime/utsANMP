package id.ac.ubaya.a160419092.model

import com.google.gson.annotations.SerializedName

data class ListResto(
    @SerializedName("restaurants")
    val resto:ArrayList<Restaurants> = ArrayList()
)