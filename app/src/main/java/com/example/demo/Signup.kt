package com.example.demo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Signup : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_signup)
        super.onCreate(savedInstanceState)

        val buttonSignup = findViewById<Button>(R.id.buttonSignup)
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val editTextBirthDate = findViewById<EditText>(R.id.editTextBirthDate)
        val textViewLoginLink = findViewById<TextView>(R.id.textViewLoginLink)



        sharedPreferences = getSharedPreferences("login_data", Context.MODE_PRIVATE)

        buttonSignup.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val gender = findViewById<RadioButton>(radioGroupGender.checkedRadioButtonId).text.toString()
            val birthDate = editTextBirthDate.text.toString()
            val password = editTextPassword.text.toString()
            saveSignupData(name, email, gender, birthDate, password)
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        textViewLoginLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
    private fun saveSignupData(
        name: String,
        email: String,
        gender: String,
        birthDate: String,
        password: String
    ) {
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("email", email)
        editor.putString("gender", gender)
        editor.putString("birthDate", birthDate)
        editor.putString("password", password)
        editor.putBoolean("isLoggedIn", true)
        editor.apply()

        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}