package id.ac.ubaya.a160419092.view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ubaya.a160419092.R
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Exit App")
            builder.setMessage("Do you want to exit?")
            builder.setNegativeButton("No"){
                Dialog, which->
            }
            builder.setPositiveButton("Yes"){
                Dialog, which ->
                activity?.finish()
            }

            val buildDialog = builder.create()
            buildDialog.show()

        }
    }
}