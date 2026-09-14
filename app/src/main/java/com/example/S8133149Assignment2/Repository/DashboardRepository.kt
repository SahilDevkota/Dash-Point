package com.example.S8133149Assignment2.Repository

import com.example.S8133149Assignment2.response.DashboardResponse
import com.example.S8133149Assignment2.service.APIService
import jakarta.inject.Inject
import retrofit2.Response

// Repository responsible for retrieving dashboard data from API
class DashboardRepository @Inject constructor(val apiService: APIService) {


    //Calls the dashboard API using the user's keypass
    suspend fun getDashboardDetail(keypass : String) : Response<DashboardResponse> {
        return apiService.dashboard(keypass)
    }

}