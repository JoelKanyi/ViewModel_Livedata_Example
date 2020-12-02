package com.kanyideveloper.viewmodel_livedata_example

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivity2ViewModel : ViewModel(){
    private lateinit var timer : CountDownTimer
    private val _seconds = MutableLiveData<Int>()
    var finished = MutableLiveData<Boolean>()
    var timerValue = MutableLiveData<Long>()

    fun seconds() : LiveData<Int>{
        return _seconds
    }

    fun startTimer(){
        timer = object : CountDownTimer(timerValue.value!!.toLong(),1000){
            override fun onFinish() {
                finished.value = true
            }

            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished/1000;
                _seconds.value = timeLeft.toInt()
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}