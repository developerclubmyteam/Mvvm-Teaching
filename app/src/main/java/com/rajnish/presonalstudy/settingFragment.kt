package com.rajnish.presonalstudy

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajnish.presonalstudy.databinding.FragmentSettingBinding


class settingFragment : Fragment(R.layout.fragment_setting) {

    private lateinit var binding: FragmentSettingBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSettingBinding.bind(view)




        val sharedPreferences= requireContext().getSharedPreferences("MyPref",Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()

        if (sharedPreferences.getBoolean("DarkMode",false)){

            binding.linearlayout.setBackgroundColor(Color.BLACK)
        }

        binding.switchbtn.setOnClickListener{



            if (binding.switchbtn.isChecked==true){

                editor.putBoolean("DarkMode",true).apply()
                binding.linearlayout.setBackgroundColor(Color.BLACK)

            }
            else{

                editor.putBoolean("DarkMode",false).apply()
                binding.linearlayout.setBackgroundColor(Color.WHITE)
            }



        }



    }


}