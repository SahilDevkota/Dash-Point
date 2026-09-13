package com.example.S8133149Assignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.S8133149Assignment2.ViewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel : LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        val usernameTextBox = findViewById<EditText>(R.id.inputBox)

        val passwordBox = findViewById<EditText>(R.id.passwordBox)

        val button = findViewById<Button>(R.id.loginButton)



        button.setOnClickListener {
            val userName = usernameTextBox.text.toString()
            val userPassword = passwordBox.text.toString()


            val intent = Intent(this, DashboardActivity::class.java)
            val toast = Toast.makeText(this,"Incorrect Password or Username",Toast.LENGTH_LONG)

            lifecycleScope.launch{
                val response = loginViewModel.sendRequest(userName,userPassword)
                val keyPass = response.body()?.keypass
                intent.putExtra("keyPass",keyPass)
                intent.putExtra("username",userName)
                when(response.code()){

                    200 -> startActivity(intent)
                    else -> toast.show()
                }
            }

        }


    }
}