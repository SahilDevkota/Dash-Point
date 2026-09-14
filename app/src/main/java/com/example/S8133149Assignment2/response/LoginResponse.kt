package com.example.S8133149Assignment2.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//Represents the login response recieved from the API
@JsonClass(generateAdapter = true)
data class LoginResponse (

    //Maps the keypass with the JSON field
    @Json(name="keypass")
    val keypass: String
)