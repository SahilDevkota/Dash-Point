package com.example.S8133149Assignment2.module

import com.example.S8133149Assignment2.service.APIService
import com.example.S8133149Assignment2.utility.RetrofitUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

//This is a hilt module that will provide dependencies throughout the application
@Module

//This ensures that these dependencies are available throughout the application.
@InstallIn(SingletonComponent::class)


object AppModule{

    //Creates and provides retrofit instance
    @Provides
    fun provideRetrofit() : Retrofit{
        val retrofit = RetrofitUtility()
        return retrofit.createRetrofit("https://nit3213apinew.onrender.com/")
    }


    // Creates the APIService using the API instance
    @Provides
    fun provideAPIService(retrofit : Retrofit) : APIService{
        return retrofit.create(APIService::class.java)
    }
}