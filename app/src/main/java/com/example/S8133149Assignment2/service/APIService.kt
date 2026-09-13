package com.example.S8133149Assignment2.service


import com.example.S8133149Assignment2.request.LoginRequest
import com.example.S8133149Assignment2.response.DashboardResponse
import com.example.S8133149Assignment2.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface APIService {

    @POST("/footscray/auth")
    suspend fun login(
        @Body request : LoginRequest
    ): Response<LoginResponse>


    @GET("/dashboard/{keypass}")
    suspend fun dashboard(@Path("keypass") keypass:String) : Response<DashboardResponse>
}