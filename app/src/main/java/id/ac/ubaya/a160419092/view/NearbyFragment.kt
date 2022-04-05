package id.ac.ubaya.a160419092.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.a160419092.R
import id.ac.ubaya.a160419092.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_nearby.*
import kotlinx.android.synthetic.main.fragment_restaurant_detail.*

class NearbyFragment : Fragment() {
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_nearby, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        observeViewModel()

        val arrayImg = arrayOf(imgResto1, imgResto2, imgResto3, imgResto4,
                                imgResto5, imgResto6, imgResto7, imgResto8,
                                imgResto9, imgResto10)
        var a=0

        for(i in 0..9){

            arrayImg[i].setOnClickListener{
                when(arrayImg[i]){
                    imgResto1->a=1
                    imgResto2->a=2
                    imgResto3->a=3
                    imgResto4->a=4
                    imgResto5->a=5
                    imgResto6->a=6
                    imgResto7->a=7
                    imgResto8->a=8
                    imgResto9->a=9
                    imgResto10->a=10
                }
                Toast.makeText(context, "id: $a", Toast.LENGTH_SHORT).show()
                val action = NearbyFragmentDirections.actionNearbyDetailFragment(a)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }

    private fun observeViewModel() {
        viewModel.resLD.observe(viewLifecycleOwner, Observer {

            for(data in it){
                when(data.id){
                    1->txtNamaResto1.setText(data.name)
                    2->txtNamaResto2.setText(data.name)
                    3->txtNamaResto3.setText(data.name)
                    4->txtNamaResto4.setText(data.name)
                    5->txtNamaResto5.setText(data.name)
                    6->txtNamaResto6.setText(data.name)
                    7->txtNamaResto7.setText(data.name)
                    8->txtNamaResto8.setText(data.name)
                    9->txtNamaResto9.setText(data.name)
                    10->txtNamaResto10.setText(data.name)
                }
            }

        })

    }

}