package com.rajnish.presonalstudy.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.rajnish.presonalstudy.db.UserDetails
import com.rajnish.presonalstudy.repository.UserRepository


class MainViewModel(private val userRepository: UserRepository) :ViewModel() {


    private val userDetailsList: LiveData<List<UserDetails>> = userRepository.getUserDetails()


    fun addUser(user:UserDetails) :Task<Void> = userRepository.addUser(user)


    fun getUserDetailsList() : LiveData<List<UserDetails>> {
        return userDetailsList
    }

    fun fetchUserDetails(){
        userRepository.fetchUserDetails()
    }

}