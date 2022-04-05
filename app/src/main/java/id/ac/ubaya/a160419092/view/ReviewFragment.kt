package id.ac.ubaya.a160419092.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.ac.ubaya.a160419092.R
import id.ac.ubaya.a160419092.model.Restaurants
import id.ac.ubaya.a160419092.model.Reviews
import id.ac.ubaya.a160419092.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_review.*

class ReviewFragment : BottomSheetDialogFragment() {
    private lateinit var viewModel: ListViewModel
    private val revListAdapter = ReviewListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val resid = ReviewFragmentArgs.fromBundle(requireArguments()).idRestoran

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = revListAdapter

        observeViewModel(resid)
    }

    private fun observeViewModel(myId:Int) {
        viewModel.resLD.observe(viewLifecycleOwner, Observer {
            for(data in it){
                if(data.id == myId){
                    revListAdapter?.updateRestaurantList(data.review)
                }
            }

        })

    }
}