package com.rajnish.presonalstudy.repository


import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import com.rajnish.presonalstudy.db.UserDetails

interface UserRepository {

    fun addUser(user:UserDetails) :Task<Void>


        fun getUserDetails(): LiveData<List<UserDetails>>
        fun fetchUserDetails()
        fun onDestroy()


}