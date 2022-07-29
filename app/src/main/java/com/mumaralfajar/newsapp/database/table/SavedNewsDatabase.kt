package com.mumaralfajar.newsapp.database.table

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mumaralfajar.newsapp.database.dao.SavedNewsDao
import com.mumaralfajar.newsapp.database.model.NewsEntity
import com.mumaralfajar.newsapp.utils.constants.Constants.SAVED_NEWS_DATABASE

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class SavedNewsDatabase : RoomDatabase() {

    abstract fun savedNewsDao(): SavedNewsDao

    companion object {
        @Volatile
        private var INSTANCE: SavedNewsDatabase? = null

        fun getInstance(context: Context): SavedNewsDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SavedNewsDatabase::class.java,
                    SAVED_NEWS_DATABASE
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}