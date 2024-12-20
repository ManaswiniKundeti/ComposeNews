package com.example.composenews.data.remoteApis

import com.example.composenews.data.remoteApis.dto.NewsResponse
import com.example.composenews.domain.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi
{
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("everything")
    suspend fun searchNews(
        @Query("q") searchQuery: String,
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}