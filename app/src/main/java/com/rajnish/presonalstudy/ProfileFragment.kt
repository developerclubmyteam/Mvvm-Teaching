package com.rajnish.presonalstudy

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rajnish.presonalstudy.databinding.FragmentHomeBinding
import com.rajnish.presonalstudy.databinding.FragmentProfileBinding


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding  = FragmentProfileBinding.bind(view)

        val sharedPreferences = requireContext().getSharedPreferences("MyPref",Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("DarkMode",false)){
            binding.linearlayout.setBackgroundColor(Color.BLACK)
        }

        val sharedPreferencess = sharedPreferences.getString("name","")
        binding.tvname.text = sharedPreferencess


        if (sharedPreferences.contains("name")){
            Toast.makeText(requireContext(), "user login second time", Toast.LENGTH_SHORT).show()
        }
        else{

            Toast.makeText(requireContext(), "user login first time", Toast.LENGTH_SHORT).show()
        }


    }


    }
