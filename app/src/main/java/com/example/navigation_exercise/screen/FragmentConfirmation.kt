package com.example.navigation_exercise.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.navigation_exercise.R
import com.example.navigation_exercise.view_model.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_confirmation.*

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentConfirmation.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentConfirmation : Fragment(), View.OnClickListener {

    val transactionViewModel by activityViewModels<TransactionViewModel>()

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
        transactionViewModel.nameReceiver.observe(viewLifecycleOwner, Observer { it -> name_receiver.text = "Sent to ${it.toString()}" })
        transactionViewModel.accountNumber.observe(viewLifecycleOwner, Observer { it -> account_number.text = it.toString() })
        transactionViewModel.amountTransfer.observe(viewLifecycleOwner, Observer { it -> amount_transfer.text = "Rp. ${it.toString()}" })
        transactionViewModel.bankName.observe(viewLifecycleOwner, Observer { it -> bank_receiver.text = it.toString() })
    }

    override fun onClick(v: View?) {
        when(v) {
            done_button -> {activity?.finish()}
        }
    }
}
