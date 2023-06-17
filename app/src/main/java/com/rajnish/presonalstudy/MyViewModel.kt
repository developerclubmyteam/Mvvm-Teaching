package com.rajnish.presonalstudy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel() {


   //// variable and function


  val count = MutableLiveData(2)

    fun increment (){
        if(count.value == 20)
        {
            count.value = 0
        }
        count.value = count.value?.plus(1)
    }

    fun decrement(){
        if(count.value!! > 0){
            count.value = count.value?.minus(1)
        }
        }






}