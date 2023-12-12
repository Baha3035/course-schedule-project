package com.alatoo.coursescheduler.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity("user")
@Parcelize
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    val course: String
): Parcelable
