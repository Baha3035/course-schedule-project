package com.alatoo.coursescheduler.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity("tasks")
@Parcelize
data class TaskItem(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var done: Boolean? = false
): Parcelable
