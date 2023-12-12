package com.alatoo.coursescheduler.retrofit

import com.alatoo.coursescheduler.entities.ScheduleItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/v4/spreadsheets/1uLmqF8Re8LVWrlAnLqINADtvv_drylmL6fNfqrUleas/values/B8:N86")
    suspend fun getSheetData(@Query("key") apiKey: String): Response<ScheduleItem>
}