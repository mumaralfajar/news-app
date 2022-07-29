package com.mumaralfajar.newsapp.api

import com.mumaralfajar.newsapp.response.ParentResponse
import com.mumaralfajar.newsapp.utils.constants.Constants.API_TOKEN
import com.mumaralfajar.newsapp.utils.constants.Constants.EN
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("top-headlines")
    suspend fun getHeadlineNews(
        @Query("apiKey") token: String = API_TOKEN,
        @Query("language") language: String = EN
    ): ParentResponse

}