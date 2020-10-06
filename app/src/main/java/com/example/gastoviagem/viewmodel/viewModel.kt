package com.example.gastoviagem.viewmodel

import androidx.lifecycle.ViewModel

class viewModel : ViewModel() {

    fun calculate(distance: String, price: String, autonomy: String): Float? {

        return if (validationOK(distance, price, autonomy)) {
            (distance.toFloat() * price.toFloat()) / autonomy.toFloat()
        } else null
    }

    private fun validationOK(distance: String, price: String, autonomy: String): Boolean {
        return (distance != "" && price != "" && autonomy != "" && autonomy != "0")
    }
}