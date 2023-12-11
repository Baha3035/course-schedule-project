package com.alatoo.coursescheduler.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alatoo.coursescheduler.entities.TaskItem

@Dao
interface TaskItemDao {
    @Insert
    suspend fun save(item: TaskItem)
    @Delete
    suspend fun deleteItem(taskItem: TaskItem)

    @Query("SELECT * FROM tasks")
    fun getAllNotes(): LiveData<List<TaskItem>>

    @Update
    suspend fun updateItem(taskItem: TaskItem)

}