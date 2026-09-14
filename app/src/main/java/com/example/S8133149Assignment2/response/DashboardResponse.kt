package com.example.S8133149Assignment2.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass



//Represents the response recieved from the API
@JsonClass(generateAdapter = true)
data class DashboardResponse(

    //Maps the entities with the JSON field
    @Json(name="entities")
    val entities : List<entityList>,

    //Maps the entityTotal with the JSON field
    @Json(name="entityTotal")
    val entityTotal : Int

)

@JsonClass(generateAdapter = true)
data class entityList(

    //Maps the courseCode with the JSON field
    @Json(name="courseCode")
    val courseCode : String,

    //Maps the courseName with the JSON field
    @Json(name="courseName")
    val courseName : String,

    //Maps the instructor with the JSON field
    @Json(name="instructor")
    val instructor : String,

    //Maps the credits with the JSON field
    @Json(name="credits")
    val credits : Int,

    //Maps the description with the JSON field
    @Json(name="description")
    val description : String

)
