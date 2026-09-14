package com.example.S8133149Assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.S8133149Assignment2.ViewModel.DashboardViewModel
import com.example.S8133149Assignment2.adapter.EntityAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch



//This allows HILT to inject dependencies to this activity
@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    // Injecting the dashboard view model
    private val dashboardViewModel : DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val intent = intent

        //Grabbing the data from previous activity
        val keyPass = intent.getStringExtra("keyPass").toString()
        val userName = intent.getStringExtra("username").toString()

        //Grabbing the id from layout(xml) files
        val recycleViewer = findViewById<RecyclerView>(R.id.recyclerView)
        val usernameBox = findViewById<TextView>(R.id.displayUsername)
        val backButton = findViewById<Button>(R.id.backToLogout)


        //displays the username to the screen
        usernameBox.text = userName

        recycleViewer.layoutManager = LinearLayoutManager(this)

        // When the button is clicked, logout and go back to log in page
        backButton.setOnClickListener {
            finish()
        }

        //Runs the API calls using a coroutine
        lifecycleScope.launch {
           try{
               //Get the dashboard data
               val response = dashboardViewModel.getTheData(keyPass)
               when(response.code()){

                   //If successful, then dashboard data gets displayed
                   200 ->  recycleViewer.adapter = EntityAdapter(response.body())

                   //Shows an error if the API returns another status code
                   else -> Toast.makeText(this@DashboardActivity,"Error : ${response.code()}",Toast.LENGTH_LONG).show()
               }

           }catch (e: Exception){

               //Shows an error if the API call fails
               Toast.makeText(this@DashboardActivity,"Error : ${e.message}", Toast.LENGTH_LONG).show()
           }
        }

    }
}