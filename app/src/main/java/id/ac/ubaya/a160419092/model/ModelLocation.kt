package id.ac.ubaya.a160419092.model

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("lat")
    val lat:String? = null,
    @SerializedName("lng")
    val lng:String? = null
)