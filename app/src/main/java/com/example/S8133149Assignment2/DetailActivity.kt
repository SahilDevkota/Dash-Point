package com.example.S8133149Assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val intent = intent

        val code = intent.getStringExtra("Code")
        val name = intent.getStringExtra("Name")
        val instructor = intent.getStringExtra("Instructor")
        val credit = intent.getStringExtra("Credits")
        val description = intent.getStringExtra("Description")

        val courseCode  = findViewById<TextView>(R.id.detailCourseCode)
        val courseName  = findViewById<TextView>(R.id.detailCourseName)
        val courseInstructor  = findViewById<TextView>(R.id.courseInstructorDetail)
        val courseCredit  = findViewById<TextView>(R.id.CourseCredit)
        val courseDescription  = findViewById<TextView>(R.id.CourseDescription)
        val button = findViewById<Button>(R.id.backButton)

        courseCode.text = code
        courseName.text = name
        courseInstructor.text = instructor
        courseCredit.text = credit
        courseDescription.text = description

        button.setOnClickListener {
            finish()
        }


    }
}