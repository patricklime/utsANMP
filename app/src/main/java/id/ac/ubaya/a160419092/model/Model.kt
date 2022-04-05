package id.ac.ubaya.a160419092.model

import com.google.gson.annotations.SerializedName

data class Restaurants(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String? = null,
    @SerializedName("address")
    val address:String? = null,
    @SerializedName("neighborhood")
    val area:String? = null,
    @SerializedName("cuisine_type")
    val menu:String? = null,
    @SerializedName("operating_hours")
    val open:OpenHours,
    @SerializedName("reviews")
   val review:ArrayList<Reviews> = ArrayList(),
    @SerializedName("latlng")
    val loc:Location
)