package com.kanyideveloper.viewmodel_livedata_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txt: TextView = findViewById(R.id.txtTimer)
        val btn_start: Button = findViewById(R.id.btnStart)
        val btn_stop: Button = findViewById(R.id.btnStop)
        val _value: EditText = findViewById(R.id.edtxtValue)

        val viewModel = ViewModelProvider(this).get(MainActivity2ViewModel::class.java)


        viewModel.seconds().observe(this, Observer {
            txt.text = it.toString()
        })

        viewModel.finished.observe(this, Observer {
            if (it){
                Toast.makeText(this, "Finished",Toast.LENGTH_SHORT).show()
            }
        })
        btn_start.setOnClickListener {
            if (_value.text.isEmpty() || _value.text.length <4){
                Toast.makeText(this, "Invalid Input",Toast.LENGTH_SHORT).show()
            }
            else{
                viewModel.timerValue.value = _value.text.toString().toLong()
                viewModel.startTimer()
            }
        }

        btn_stop.setOnClickListener {
            txt.text = "0"
            viewModel.stopTimer()
        }
    }
}