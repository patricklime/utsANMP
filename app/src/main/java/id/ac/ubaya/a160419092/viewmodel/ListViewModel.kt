package id.ac.ubaya.a160419092.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.a160419092.model.ListResto
import id.ac.ubaya.a160419092.model.Restaurants

class ListViewModel(application: Application):AndroidViewModel(application) {
    val resLD = MutableLiveData<List<Restaurants>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

   val TAG = "volleyTag"
    private var queue:RequestQueue?= null

    fun refresh(){
       loadingErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())

        val url = "https://gist.githubusercontent.com/yoobi55/5d36f13e902a75225a39a8caa5556551/raw/cbd57cfdddbdfc009fd9ccdadf5fb7129af71c73/restaurant-data.json"

        val stringReq = StringRequest(Request.Method.GET, url,
                            {
                                val stype = object : TypeToken<ListResto>() {}.type
                                val result = Gson().fromJson<ListResto>(it, stype)
                                resLD.value = result.resto

                                loadingLD.value = false
                                Log.d("show success", result.toString())
                            },
                            {
                                Log.d("show error", it.toString())
                                loadingErrorLD.value = true
                                loadingLD.value = false
                            }
                        )
        stringReq.tag = TAG
        queue?.add(stringReq)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}