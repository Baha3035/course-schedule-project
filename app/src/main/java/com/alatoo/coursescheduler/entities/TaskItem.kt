package com.alatoo.coursescheduler.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class TaskItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val done: Boolean = false
): Serializable
