package com.kanyideveloper.viewmodel_livedata_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val btn: Button = findViewById(R.id.btnAdd)
        val btn2: Button = findViewById(R.id.btnReset)
        val txt: TextView = findViewById(R.id.txtNum)

        txt.text = viewModel.number.toString()
        btn.setOnClickListener {
            viewModel.addNum()
            txt.text = viewModel.number.toString()
        }

        btn2.setOnClickListener {
            viewModel.clearNum()
            txt.text = viewModel.number.toString()
        }
    }
}