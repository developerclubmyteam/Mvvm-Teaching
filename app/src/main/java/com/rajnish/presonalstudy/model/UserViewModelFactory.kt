package com.rajnish.presonalstudy.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajnish.presonalstudy.repository.UserRepository

class UserViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}
