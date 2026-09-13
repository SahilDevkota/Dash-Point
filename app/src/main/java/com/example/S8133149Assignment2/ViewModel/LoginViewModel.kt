package com.example.S8133149Assignment2.ViewModel

import androidx.lifecycle.ViewModel
import com.example.S8133149Assignment2.Repository.UserRepository
import com.example.S8133149Assignment2.request.LoginRequest
import com.example.S8133149Assignment2.response.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
    class LoginViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    suspend fun sendRequest(userName: String, userPassword: String) : Response<LoginResponse>{

        val request = LoginRequest(
            username = userName,
            password = userPassword
        )

        return userRepository.login(request)
    }

}