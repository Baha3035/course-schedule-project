package com.alatoo.coursescheduler.entities

import java.io.Serializable

data class TaskItem(
    val name: String,
    val done: Boolean = false
): Serializable
