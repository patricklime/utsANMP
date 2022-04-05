package id.ac.ubaya.a160419092.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.ac.ubaya.a160419092.R
import id.ac.ubaya.a160419092.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_nearby_detail.*
import kotlinx.android.synthetic.main.review_list_item.*

class NearbyDetailFragment : Fragment() {
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nearby_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resid = NearbyDetailFragmentArgs.fromBundle(requireArguments()).restoid

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        observeViewModel(resid)

        buttonDetail.setOnClickListener {
            val action = NearbyDetailFragmentDirections.actionNearbyRestaurantDetailFragment(resid)
                Navigation.findNavController(it).navigate(action)
        }
    }

    private fun observeViewModel(myId:Int) {
        viewModel.resLD.observe(viewLifecycleOwner, Observer {
            var rate = 0.0;

            for(i in it){
                if(i.id == myId){
                    txtNamaResto.setText(i.name)
                    txtKoordinat.setText("Koordinat: "+ i.loc.lat + ", " + i.loc.lng)

                    for(data in i.review){
                         rate += data.rating!!
                    }
                    val rates = (rate/i.review.size)

                    txtRating.setText("%.1f".format(rates))

                    if(i.id != 8){
                        imageResto.setImageResource(this.resources.getIdentifier("resto$myId","drawable",context?.packageName))
                    }
                    else{
                        imageResto.setImageResource(this.resources.getIdentifier("resto5","drawable",context?.packageName))
                    }
                    txtAlamatResto.setText("Alamat: "+i.address)
                }
            }

        })

    }
}