package com.alatoo.coursescheduler.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alatoo.coursescheduler.repository.UserRepository
import com.alatoo.coursescheduler.entities.User
import kotlinx.coroutines.launch


class UserViewModel(private val repository: UserRepository): ViewModel() {

    val user = repository.user

    fun save(user: User){
        viewModelScope.launch {
            repository.save(user)
        }
    }

    fun update(user: User){
        viewModelScope.launch {
            repository.update(user)
        }
    }

}