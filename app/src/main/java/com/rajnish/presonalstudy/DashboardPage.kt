package com.rajnish.presonalstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.rajnish.presonalstudy.databinding.ActivityDasboardPageBinding

class DashboardPage : AppCompatActivity() {

    private lateinit var binding: ActivityDasboardPageBinding
    private lateinit var arrayList: ArrayList<String>
    private lateinit var arraAdapter:ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDasboardPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        arrayList = arrayListOf()
        arrayList.add("Education")
        arrayList.add("Technology")
        arrayList.add("Movies")
        arrayList.add("Business")
        arrayList.add("General")
        arrayList.add("Cricket")

        arraAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList)

        binding.listview.adapter = arraAdapter

        binding.listview.setOnItemClickListener{parent ,id,possiton,view->

           val intent = Intent(this,NewsDetails::class.java)
               intent.putExtra("Catagory",arrayList[possiton])
            startActivity(intent)

        }

        binding.gotoProfile.setOnClickListener {
            val intent = Intent(this,ProfilePage ::class.java)
            startActivity(intent)

        }

        binding.add.setOnClickListener{

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }



    }
}