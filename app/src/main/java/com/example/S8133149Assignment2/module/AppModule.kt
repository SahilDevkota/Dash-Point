package com.example.S8133149Assignment2.module

import com.example.S8133149Assignment2.service.APIService
import com.example.S8133149Assignment2.utility.RetrofitUtility
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)


object AppModule{

    @Provides
    fun provideRetrofit() : Retrofit{
        val retrofit = RetrofitUtility()
        return retrofit.createRetrofit("https://nit3213apinew.onrender.com/")
    }

    @Provides
    fun provideAPIService(retrofit : Retrofit) : APIService{
        return retrofit.create(APIService::class.java)
    }
}