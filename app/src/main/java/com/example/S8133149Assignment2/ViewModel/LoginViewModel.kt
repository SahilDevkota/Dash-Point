package com.example.S8133149Assignment2.ViewModel

import androidx.lifecycle.ViewModel
import com.example.S8133149Assignment2.Repository.UserRepository
import com.example.S8133149Assignment2.request.LoginRequest
import com.example.S8133149Assignment2.response.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


//Handles login data for UI
@HiltViewModel
    class LoginViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    suspend fun sendRequest(userName: String, userPassword: String) : Response<LoginResponse>{

        //It creates the login request
        val request = LoginRequest(
            username = userName,
            password = userPassword
        )

        //Sends the request to the API through the repository
        return userRepository.login(request)
    }

}