package com.example.S8133149Assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


//Displays the details of the selected course
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val intent = intent

        // Gets the data passed from previous activity
        val code = intent.getStringExtra("Code")
        val name = intent.getStringExtra("Name")
        val instructor = intent.getStringExtra("Instructor")
        val credit = intent.getIntExtra("Credits",0)
        val description = intent.getStringExtra("Description")

        //Grabs the ids from layout xml file
        val courseCode  = findViewById<TextView>(R.id.detailCourseCode)
        val courseName  = findViewById<TextView>(R.id.detailCourseName)
        val courseInstructor  = findViewById<TextView>(R.id.courseInstructorDetail)
        val courseCredit  = findViewById<TextView>(R.id.CourseCredit)
        val courseDescription  = findViewById<TextView>(R.id.CourseDescription)
        val button = findViewById<Button>(R.id.backButton)

        // Assigns the value to respective Textviews and buttons
        courseCode.text = code
        courseName.text = name
        courseInstructor.text = instructor
        courseCredit.text = credit.toString()
        courseDescription.text = description


        //When the button is clicked, the user will return back to dashboard activity.
        button.setOnClickListener {
            finish()
        }


    }
}