package com.rajnish.presonalstudy


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rajnish.presonalstudy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    private lateinit var db :DatabaseReference
    var catagory : String = ""

    protected lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = FirebaseDatabase.getInstance().reference.child("News")




        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController


        binding.bottomNevigation.setupWithNavController(navController)




    }







}