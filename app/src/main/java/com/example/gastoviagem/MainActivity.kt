package com.example.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.gastoviagem.viewmodel.viewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //--> Instanciar ViewModel <--//
        val viewModel: viewModel =
            ViewModelProviders.of(this).get(viewModel::class.java)

        buttonCalc.setOnClickListener {

            //--> Instanciar variaveis view <--//
            val distance = editDistance.text.toString()
            val price = editPrice.text.toString()
            val autonomy = editAutonomy.text.toString()

            if (distance.isNotEmpty() && price.isNotEmpty() && autonomy.isNotEmpty()) {
                textTotalValue.text =
                    "R$ ${"%.2f".format(viewModel.calculate(distance, price, autonomy))}"

            } else Toast.makeText(this, "Favor, digitar todos os valores!", Toast.LENGTH_SHORT)
                .show()
        }
    }
}
