package com.example.S8133149Assignment2.Repository

import com.example.S8133149Assignment2.response.DashboardResponse
import com.example.S8133149Assignment2.service.APIService
import jakarta.inject.Inject
import retrofit2.Response


class DashboardRepository @Inject constructor(val apiService: APIService) {

    suspend fun getDashboardDetail(keypass : String) : Response<DashboardResponse> {
        return apiService.dashboard(keypass)
    }

}