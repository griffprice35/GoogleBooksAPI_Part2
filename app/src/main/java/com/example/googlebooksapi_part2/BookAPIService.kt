package com.example.googlebooksapi_part2

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val QUERY_STRING =
    "volumes?q=android&maxResults=5"

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build()

interface BookAPIService {
    @GET(QUERY_STRING)
    fun getBooks(): Call<String>
}

object BookAPI{
    val bookApi: BookAPIService by lazy {
        retrofit.create(BookAPIService::class.java)
    }
}