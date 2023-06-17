package com.rajnish.presonalstudy


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider


import com.rajnish.presonalstudy.databinding.ActivityPrintBinding

class PrintActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrintBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_print)
        setContentView(binding.root)


        val model = ViewModelProvider(this)[MyViewModel::class.java]
        binding.mymodel = model
        binding.lifecycleOwner = this




    }
}