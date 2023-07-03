package com.rajnish.presonalstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rajnish.presonalstudy.adapter.NewsAdapter
import com.rajnish.presonalstudy.databinding.ActivityNewsDetailsBinding
import com.rajnish.presonalstudy.db.News

class NewsDetails : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDetailsBinding
    private lateinit var db :DatabaseReference
    private lateinit var arrayList: ArrayList<News>
    private lateinit var addapter: NewsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val categories = intent.getStringExtra("Catagory")

        arrayList= arrayListOf()


        db = FirebaseDatabase.getInstance().reference.child("News").child(categories!!)

        binding.textview.text = categories
        fatchNews()

        addapter = NewsAdapter(arrayList)
        binding.recycleView.adapter= addapter
        binding.recycleView.layoutManager= LinearLayoutManager(this)

    }
    fun fatchNews(){

        db.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){
                    for (data in snapshot.children){
                        val title = data . child("title") .value as String
                        val discription = data . child("discription") .value as String
                        val imgUri = data . child("imgUri") .value as String
                        arrayList.add(News(title,discription, imgUri))

                    }
                    addapter.notifyDataSetChanged()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }

}