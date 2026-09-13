package com.example.S8133149Assignment2.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



@JsonClass(generateAdapter = true)
data class DashboardResponse(

    @Json(name="entities")
    val entities : List<entityList>,

    @Json(name="entityTotal")
    val entityTotal : Int

)

@JsonClass(generateAdapter = true)
data class entityList(

    @Json(name="courseCode")
    val courseCode : String,

    @Json(name="courseName")
    val courseName : String,

    @Json(name="instructor")
    val instructor : String,

    @Json(name="credits")
    val credits : Int,

    @Json(name="description")
    val description : String

)
