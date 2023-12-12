package com.alatoo.coursescheduler.dataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.alatoo.coursescheduler.entities.User
@Dao
interface UserDao {

    @Insert
    suspend fun save(user: User)

    @Update
    suspend fun update(user: User)

    @Query("SELECT * FROM user")
    fun getUser(): LiveData<List<User>>

}