package com.mumaralfajar.newsapp.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.mumaralfajar.newsapp.database.table.SavedNewsDatabase
import com.mumaralfajar.newsapp.utils.constants.Constants.SAVED_NEWS_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideSavedNewsDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        SavedNewsDatabase::class.java,
        SAVED_NEWS_DATABASE
    ).build()

    @Singleton
    @Provides
    fun provideSavedNewsDao(database: SavedNewsDatabase) = database.savedNewsDao()

}