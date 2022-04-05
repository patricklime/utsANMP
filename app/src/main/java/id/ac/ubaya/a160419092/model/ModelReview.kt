package id.ac.ubaya.a160419092.model

import com.google.gson.annotations.SerializedName

data class Reviews(
    @SerializedName("rating")
    val rating:Double?,
    @SerializedName("name")
    val name:String? = null,
    @SerializedName("comments")
    val comment:String? = null,
    @SerializedName("date")
    val date:String? = null

)