package com.example.navigation_exercise.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigation_exercise.R
import kotlinx.android.synthetic.main.fragment_recipient.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentRecipient.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentRecipient : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        next_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            next_button -> {
                var bundle = bundleOf("name" to recipient_name_text.text.toString())
                navController.navigate(R.id.action_fragmentRecipient_to_fragmentInputAmout, bundle)
            }
        }
    }
}
