package com.example.S8133149Assignment2.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class LoginResponse (

    @Json(name="keypass")
    val keypass: String
)