package com.alatoo.coursescheduler.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alatoo.coursescheduler.repository.Repository
import com.alatoo.coursescheduler.entities.TaskItem
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val items = repository.getAllItems()

    fun insertItem(taskItem: TaskItem){
        viewModelScope.launch {
            repository.insertItem(taskItem)
        }
    }

    fun deleteItem(taskItem: TaskItem){
        viewModelScope.launch {
            repository.deleteItem(taskItem)
        }
    }

    fun updateItem(taskItem: TaskItem){
        viewModelScope.launch {
            repository.updateItem(taskItem)
        }
    }

}