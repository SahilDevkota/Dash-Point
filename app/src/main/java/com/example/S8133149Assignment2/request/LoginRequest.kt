package com.example.S8133149Assignment2.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


//Represents the login data sent to the user
@JsonClass(generateAdapter = true)
data class LoginRequest (

    //Maps the username with the JSON field
    @Json(name="username")
    val username: String,

    //Maps the password with the JSON field
    @Json(name="password")
    val password: String


    )