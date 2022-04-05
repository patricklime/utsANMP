package id.ac.ubaya.a160419092.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.a160419092.R
import id.ac.ubaya.a160419092.model.Restaurants
import id.ac.ubaya.a160419092.model.Reviews
import kotlinx.android.synthetic.main.restaurant_list_item.view.*
import kotlinx.android.synthetic.main.review_list_item.view.*

class ReviewListAdapter(val reviewList:ArrayList<Reviews>): RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder>() {
    class ReviewViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateRestaurantList(newRestaurantList:List<Reviews>){
        reviewList.clear()
        reviewList.addAll(newRestaurantList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val infalter = LayoutInflater.from(parent.context)
        val v = infalter.inflate(R.layout.review_list_item, parent, false)

        return ReviewListAdapter.ReviewViewHolder(v)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.view.txtNamaReviewer.text = reviewList[position].name
        holder.view.txtRate.text = reviewList[position].rating.toString()
        holder.view.txtIsiKomen.text = reviewList[position].comment
            holder.view.txtTgl.text = reviewList[position].date
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }


}