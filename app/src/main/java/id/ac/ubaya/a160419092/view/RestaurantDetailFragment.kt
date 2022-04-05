package id.ac.ubaya.a160419092.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.a160419092.R
import id.ac.ubaya.a160419092.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_restaurant_detail.*

class RestaurantDetailFragment : Fragment() {
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resid = RestaurantDetailFragmentArgs.fromBundle(requireArguments()).idResto

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        observeViewModel(resid)

        btnMore.setOnClickListener {
            val action = RestaurantDetailFragmentDirections.actionReviewFragment(resid)
            Navigation.findNavController(it).navigate(action)
        }
    }

    private fun observeViewModel(myId:Int) {
        viewModel.resLD.observe(viewLifecycleOwner, Observer {

            for(i in it){
                if(i.id == myId){
                    txtTitle.setText(i.name)
                    txtDataDescription.setText("Menu: "+ i.menu + "\n\nAlamat: " + i.address + "\n\nKawasan: " + i.area)

                    if(i.id != 8){
                        imageViewRestaurant.setImageResource(this.resources.getIdentifier("resto$myId","drawable",context?.packageName))

                    }
                    else{
                        imageViewRestaurant.setImageResource(this.resources.getIdentifier("resto5","drawable",context?.packageName))
                    }

                    txtDataOpen.setText("")
                    txtDataOpen.append("Sun\t\t" + i.open.sunday +"\n")
                    txtDataOpen.append("Mon\t\t" + i.open.monday +"\n")
                    txtDataOpen.append("Tue\t\t" + i.open.tuesday +"\n")
                    txtDataOpen.append("Wed\t\t" + i.open.wednesday +"\n")
                    txtDataOpen.append("Thu\t\t" + i.open.thursday +"\n")
                    txtDataOpen.append("Fri\t\t" + i.open.friday +"\n")
                    txtDataOpen.append("Sat\t\t" + i.open.saturday)
                }
            }

        })

    }
}