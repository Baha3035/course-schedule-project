package com.alatoo.coursescheduler.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alatoo.coursescheduler.entities.TaskItem
import com.alatoo.coursescheduler.entities.User

@Database(entities = [TaskItem::class, User::class], version = 2, exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract fun taskItemDao(): TaskItemDao
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: DataBase ?= null
        fun getDatabase(context: Context): DataBase{
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "dataBase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}