package com.example.myapplication


import retrofit2.http.GET
import retrofit2.http.Query

interface Github {
    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getMovies(): retrofit2.Call<PopularRepos>
}