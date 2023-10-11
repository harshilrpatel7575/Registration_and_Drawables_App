package com.example.demo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val goTosignup = findViewById<TextView>(R.id.hypersignup)

        sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        
            buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()


            if (isValidCredentials(email, password)) {
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show()
            }
        }

           goTosignup.setOnClickListener{
               startActivity(Intent(this, Signup::class.java))
               finish()
           }
    }

    private fun isValidCredentials(email: String, password: String): Boolean {
        return email == "harshil@gmail.com" && password == "12345678"
    }
}