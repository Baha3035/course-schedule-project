package com.alatoo.coursescheduler.dataBase

import com.alatoo.coursescheduler.entities.TaskItem

class Repository(private val db: TaskItemDao){

    fun getAllItems() = db.getAllNotes()

    suspend fun insertItem(item: TaskItem) = db.save(item)

    suspend fun updateItem(item: TaskItem) = db.updateItem(item)

    suspend fun deleteItem(item: TaskItem) = db.deleteItem(item)

}