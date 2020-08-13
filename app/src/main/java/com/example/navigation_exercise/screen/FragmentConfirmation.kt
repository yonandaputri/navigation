package com.example.navigation_exercise.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation_exercise.R
import kotlinx.android.synthetic.main.fragment_confirmation.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentConfirmation.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentConfirmation : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        done_button.setOnClickListener(this)
        name_receiver.text = "Name\t: " + arguments?.getString("name")
        amount_transfer.text = "Amount\t: " + arguments?.getString("amount")
    }

    override fun onClick(v: View?) {
        when(v) {
            done_button -> {activity?.finish()}
        }
    }
}
