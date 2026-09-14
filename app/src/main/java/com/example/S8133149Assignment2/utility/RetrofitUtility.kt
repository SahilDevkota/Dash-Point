package com.example.S8133149Assignment2.utility

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//Utility class for creating the Retrofit client
class RetrofitUtility {

    //Shows API requests and responses for debugging
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    // Converts JSON to kotlin objects and vice versa
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    //Creates the HTTP client
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    //Creates and configures Retrofit
    fun createRetrofit(baseurl: String) = Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .build()

}