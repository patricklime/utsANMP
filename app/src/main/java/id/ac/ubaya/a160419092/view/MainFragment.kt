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
import id.ac.ubaya.a160419092.R
import id.ac.ubaya.a160419092.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private val resListAdapter = restaurantAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = resListAdapter

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.resLD.observe(viewLifecycleOwner, Observer {
            resListAdapter?.updateRestaurantList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, Observer {
            if(it){
                Toast.makeText(context, "error bro!", Toast.LENGTH_SHORT).show()
                textViewError.visibility = View.VISIBLE
            }
            else{
                Toast.makeText(context, "no error!", Toast.LENGTH_SHORT).show()
                textViewError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == false){
                recyclerView.visibility = View.VISIBLE
                Toast.makeText(context, "no loading", Toast.LENGTH_SHORT).show()
            }
            else{
                recyclerView.visibility = View.GONE
                Toast.makeText(context, "loading bro!", Toast.LENGTH_SHORT).show()
            }
        })
    }

}