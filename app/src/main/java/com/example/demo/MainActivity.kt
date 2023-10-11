package com.example.demo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonLogout= findViewById<Button>(R.id.buttonLogin1)

        sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE)

        buttonLogout.setOnClickListener {
            clearUserData()
            redirectToLogin()
        }

    }
    private fun clearUserData() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    private fun redirectToLogin() {

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}