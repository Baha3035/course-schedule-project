package com.alatoo.coursescheduler.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alatoo.coursescheduler.entities.TaskItem

@Database(entities = [TaskItem::class], version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract fun taskItemDao(): TaskItemDao

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