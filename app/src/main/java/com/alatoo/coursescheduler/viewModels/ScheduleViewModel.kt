package com.alatoo.coursescheduler.viewModels

import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alatoo.coursescheduler.entities.ScheduleItem
import com.alatoo.coursescheduler.repository.ScheduleRepository
import kotlinx.coroutines.launch

class ScheduleViewModel: ViewModel() {
    val repository = ScheduleRepository()
    val scheduleResponse: MutableLiveData<ScheduleItem> = MutableLiveData()

    fun getSchedule(){
        viewModelScope.launch {
            val response = repository.getSchedule()
            scheduleResponse.postValue(response.body())
        }
    }



}