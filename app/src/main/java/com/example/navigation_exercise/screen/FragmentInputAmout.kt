package com.example.navigation_exercise.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigation_exercise.R
import com.example.navigation_exercise.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_input_amout.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInputAmout.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInputAmout : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_amout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_button.setOnClickListener(this)
        transactionViewModel.nameReceiver.observe(viewLifecycleOwner, Observer { it -> name_receiver_transfer.text = "To : ${it.toString()}" })
    }

    override fun onClick(v: View?) {
        when(v) {
            send_button -> {
                transactionViewModel.setAmountTransfer(recipient_amount_text.text.toString())
                navController.navigate(R.id.action_fragmentInputAmout_to_fragmentConfirmation)
            }
        }
    }
}
