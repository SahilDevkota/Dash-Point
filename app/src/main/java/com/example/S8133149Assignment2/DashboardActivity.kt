package com.example.S8133149Assignment2

import android.os.Bundle
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


@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val dashboardViewModel : DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val intent = intent

        val keyPass = intent.getStringExtra("keyPass").toString()
        val userName = intent.getStringExtra("username").toString()

        val recycleViewer = findViewById<RecyclerView>(R.id.recyclerView)
        val usernameBox = findViewById<TextView>(R.id.displayUsername)




        usernameBox.text = userName

        recycleViewer.layoutManager = LinearLayoutManager(this)


        lifecycleScope.launch {
           try{
               val response = dashboardViewModel.getTheData(keyPass)
               when(response.code()){
                   200 ->  recycleViewer.adapter = EntityAdapter(response.body())
                   else -> Toast.makeText(this@DashboardActivity,"Error : ${response.code()}",Toast.LENGTH_LONG).show()
               }

           }catch (e: Exception){
               Toast.makeText(this@DashboardActivity,"Error : ${e.message}", Toast.LENGTH_LONG).show()
           }
        }

    }
}