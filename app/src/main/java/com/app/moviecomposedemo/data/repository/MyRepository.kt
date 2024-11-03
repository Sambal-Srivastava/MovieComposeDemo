package com.app.moviecomposedemo.data.repository

import com.app.moviecomposedemo.network.ApiService
import com.app.moviecomposedemo.data.model.MockResponseDto
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getMovies(apiKey:String, searchQuery:String): MockResponseDto.MockResponse {
        return apiService.getMovies(apiKey, searchQuery)
    }

    suspend fun getMovieDetails(movieId: String, apiKey:String): MockResponseDto.MovieDetailsResponse {
        var resp = apiService.getMovieDetails(movieId, apiKey)
        return apiService.getMovieDetails(movieId, apiKey)
    }
}