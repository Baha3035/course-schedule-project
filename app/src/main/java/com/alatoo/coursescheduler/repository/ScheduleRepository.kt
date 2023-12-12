package com.alatoo.coursescheduler.repository

import com.alatoo.coursescheduler.retrofit.RetrofitInstance

class ScheduleRepository {

    suspend fun getSchedule() = RetrofitInstance.api.getSheetData("AIzaSyAtG2Ad-DnN-O12rMHsW8HQ0hFZ8Fib5B4")

}