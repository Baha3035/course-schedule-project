package com.alatoo.coursescheduler.entities

import java.io.Serializable

data class ScheduleItem(
    val majorDimension: String,
    val range: String,
    val values: List<List<String>>
): Serializable