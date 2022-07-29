package com.mumaralfajar.newsapp.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.mumaralfajar.newsapp.database.model.NewsEntity
import com.mumaralfajar.newsapp.mapper.NewsMapper
import com.mumaralfajar.newsapp.mapper.SavedMapper
import com.mumaralfajar.newsapp.mapper.SourceMapper
import com.mumaralfajar.newsapp.model.NewsModel
import com.mumaralfajar.newsapp.model.SourceModel
import com.mumaralfajar.newsapp.response.NewsResponse
import com.mumaralfajar.newsapp.response.SourceResponse
import com.mumaralfajar.newsapp.utils.interfaces.Mapper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    @Singleton
    abstract fun bindNewsMapper(mapper: NewsMapper): Mapper<NewsResponse, NewsModel>

    @Binds
    @Singleton
    abstract fun bindSourceMapper(mapper: SourceMapper): Mapper<SourceResponse, SourceModel>

    @Binds
    @Singleton
    abstract fun bindSavedNewsMapper(mapper: SavedMapper): Mapper<NewsModel, NewsEntity>

}