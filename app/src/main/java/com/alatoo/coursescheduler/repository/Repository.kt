package com.alatoo.coursescheduler.repository

import com.alatoo.coursescheduler.dataBase.TaskItemDao
import com.alatoo.coursescheduler.entities.TaskItem

class Repository(private val db: TaskItemDao){

    fun getAllItems() = db.getAllNotes()

    suspend fun insertItem(item: TaskItem) = db.save(item)

    suspend fun updateItem(item: TaskItem) = db.updateItem(item)

    suspend fun deleteItem(item: TaskItem) = db.deleteItem(item)

}