package com.kanyideveloper.viewmodel_livedata_example

import androidx.lifecycle.ViewModel


private var num: Int  = 0
class MainViewModel : ViewModel(){
    var number = 0

    fun addNum(){
        number++
    }

    fun clearNum(){
        number = 0
    }
}