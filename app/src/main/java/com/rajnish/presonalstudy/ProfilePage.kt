package com.rajnish.presonalstudy


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rajnish.presonalstudy.databinding.ActivityProfilePageBinding
import com.squareup.picasso.Picasso

class ProfilePage : AppCompatActivity() {
    private lateinit var binding:ActivityProfilePageBinding
    private lateinit var db : DatabaseReference
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = applicationContext.getSharedPreferences("MyPref", MODE_PRIVATE)
        val emailId = sharedPreferences.getString("emailId","")
//        val emailId = intent.getStringExtra("emailId")
        db = FirebaseDatabase.getInstance().reference.child("User Profile").child(emailId!!)


        retriveData()

        binding.btn.setOnClickListener{
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this,LoginPage::class.java)
            intent.putExtra("emailId",emailId)
            startActivity(intent)

        }



    }

    fun retriveData(){

        db.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){

                    val firstname = snapshot.child("firstName"). value as String
                    val emailId = snapshot.child("emailId"). value as String
                    val bio = snapshot.child("bio"). value as String
                    val imageUri = snapshot.child("imageUri"). value as String

                    binding.firstName.text = firstname
                    binding.email.text = emailId
                    binding.bio.text = bio

                    Picasso.get().load(imageUri).into(binding.profilePicture)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }

}