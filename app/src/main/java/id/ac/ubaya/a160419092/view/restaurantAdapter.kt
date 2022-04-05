package id.ac.ubaya.a160419092.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.a160419092.R
import id.ac.ubaya.a160419092.model.Restaurants
import kotlinx.android.synthetic.main.restaurant_list_item.view.*

class restaurantAdapter(val restaurantList:ArrayList<Restaurants>):RecyclerView.Adapter<restaurantAdapter.RestaurantViewHolder>(){
    class RestaurantViewHolder(val view:View):RecyclerView.ViewHolder(view)

    fun updateRestaurantList(newRestaurantList:List<Restaurants>){
        restaurantList.clear()
        restaurantList.addAll(newRestaurantList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
      val infalter = LayoutInflater.from(parent.context)
      val v = infalter.inflate(R.layout.restaurant_list_item, parent, false)

        return RestaurantViewHolder(v)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.view.txtName.text = restaurantList[position].name
        holder.view.txtMenu.text = "Menu : "+restaurantList[position].menu
        holder.view.txtAddress.text = "Lokasi : "+ restaurantList[position].address

        when(restaurantList[position].id){
            1->holder.view.imageView.setImageResource(R.drawable.resto1)
            2->holder.view.imageView.setImageResource(R.drawable.resto2)
            3->holder.view.imageView.setImageResource(R.drawable.resto3)
            4->holder.view.imageView.setImageResource(R.drawable.resto4)
            5->holder.view.imageView.setImageResource(R.drawable.resto5)
            6->holder.view.imageView.setImageResource(R.drawable.resto6)
            7->holder.view.imageView.setImageResource(R.drawable.resto7)
            8->holder.view.imageView.setImageResource(R.drawable.resto5)
            9->holder.view.imageView.setImageResource(R.drawable.resto9)
            10->holder.view.imageView.setImageResource(R.drawable.resto10)
        }

        holder.view.btnDetail.setOnClickListener {
            val resId = restaurantList[position].id
            val action = MainFragmentDirections.actionRestaurantDetailFragment(resId)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
       return restaurantList.size
    }
}
