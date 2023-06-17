package com.rajnish.presonalstudy.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rajnish.presonalstudy.db.UserDetails

class UserRepositoryImp : UserRepository {

    private  var db: DatabaseReference =FirebaseDatabase.getInstance().reference.child("User MVVM")
    private val userDetailsList: MutableLiveData<List<UserDetails>> = MutableLiveData()
    private lateinit var userValueEventListener: ValueEventListener


    override fun addUser(user: UserDetails): Task<Void> {


        return db.setValue(user)
    }

    override fun getUserDetails(): LiveData<List<UserDetails>> {
        return userDetailsList
    }

    override fun fetchUserDetails() {
        db.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val userList: MutableList<UserDetails> = mutableListOf()
                for (userSnapshot in dataSnapshot.children) {
                    val user = userSnapshot.getValue(UserDetails::class.java)
                    user?.let { userList.add(it) }
                }
                userDetailsList.value = userList
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error
            }
        })
    }



    override fun onDestroy() {
        db.removeEventListener(userValueEventListener)
    }



}
