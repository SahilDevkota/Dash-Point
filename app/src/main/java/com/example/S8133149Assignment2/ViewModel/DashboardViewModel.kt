package com.example.S8133149Assignment2.ViewModel

import androidx.lifecycle.ViewModel
import com.example.S8133149Assignment2.Repository.DashboardRepository
import com.example.S8133149Assignment2.response.DashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import retrofit2.Response


//Handles dashboard data for the UI
@HiltViewModel
class DashboardViewModel @Inject constructor(val dashboardRepository: DashboardRepository) :  ViewModel(){


    //Gets dashboard data from the repository
    suspend fun getTheData(keypass : String) : Response<DashboardResponse> {
        return dashboardRepository.getDashboardDetail(keypass)
    }
}