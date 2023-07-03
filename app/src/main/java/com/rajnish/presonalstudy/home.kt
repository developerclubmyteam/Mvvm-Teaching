package com.rajnish.presonalstudy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajnish.presonalstudy.databinding.FragmentHomeBinding

class home : Fragment(R.layout.fragment_home) {

   private lateinit var binding: FragmentHomeBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)


        val sharedPreferences = requireContext().getSharedPreferences("MyPref",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("DarkMode",false)){

            binding.linearlayout.setBackgroundColor(Color.BLACK)
        }

        val sharename = sharedPreferences.getString("name","null")
        binding.tvName.text = sharename



        binding.addbtn.setOnClickListener {


            val editor = sharedPreferences.edit()
            editor.putString("name","sohan Das")
            editor.apply()


            val sharename = sharedPreferences.getString("name","null")
           binding.tvName.text = sharename


        }









    }
}