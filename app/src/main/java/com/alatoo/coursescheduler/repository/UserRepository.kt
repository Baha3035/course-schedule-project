package com.alatoo.coursescheduler.repository

import com.alatoo.coursescheduler.dataBase.UserDao
import com.alatoo.coursescheduler.entities.User

class UserRepository(private val db: UserDao) {

    val user = db.getUser()

    suspend fun save(user: User) = db.save(user)

    suspend fun update(user: User) = db.update(user)

}