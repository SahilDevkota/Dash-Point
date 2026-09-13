package com.example.S8133149Assignment2.Repository

import com.example.S8133149Assignment2.request.LoginRequest
import com.example.S8133149Assignment2.response.LoginResponse
import com.example.S8133149Assignment2.service.APIService
import jakarta.inject.Inject
import retrofit2.Response

class UserRepository @Inject constructor(
    private val apiService : APIService
)
{
    suspend fun login(request: LoginRequest) : Response<LoginResponse>{
        return apiService.login(request)
    }
}