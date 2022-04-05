package id.ac.ubaya.a160419092.model

import com.google.gson.annotations.SerializedName


data class OpenHours(
    @SerializedName("Sunday")
    val sunday:String? = null,
    @SerializedName("Monday")
    val monday:String? = null,
    @SerializedName("Tuesday")
    val tuesday:String? = null,
    @SerializedName("Wednesday")
    val wednesday:String? = null,
    @SerializedName("Thursday")
    val thursday:String? = null,
    @SerializedName("Friday")
    val friday:String? = null,
    @SerializedName("Saturday")
    val saturday:String? = null
)