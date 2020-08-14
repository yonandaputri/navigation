package com.example.navigation_exercise.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TransactionViewModel : ViewModel() {
    var bankName: MutableLiveData<String> = MutableLiveData("")
    var accountNumber: MutableLiveData<String> = MutableLiveData("")
    var nameReceiver: MutableLiveData<String> = MutableLiveData("")
    var amountTransfer: MutableLiveData<String> = MutableLiveData("")

    fun setBankName(bank: String) {
        bankName.value = bank
    }

    fun setAccountNumber(accountNumb: String) {
        accountNumber.value = accountNumb
    }

    fun setNameReceiver(name: String) {
        nameReceiver.value = name
    }

    fun setAmountTransfer(amount: String) {
        amountTransfer.value = amount
    }
}