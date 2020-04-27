package com.android.gsixacademy.myappkotlinonline

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var mySharedPreferences = getSharedPreferences("KotlinBasicTutorialPreferences", Context.MODE_PRIVATE)

        if (mySharedPreferences.contains("userName")) { startActivity(Intent(applicationContext, UserSignedInActivity::class.java))
        }
        button_sign_in.setOnClickListener {
            var userName = edit_text_username.text.toString()
            var password = edit_text_password.text.toString()

            mySharedPreferences.edit().putString("userName", userName).apply()
            mySharedPreferences.edit().putString("password", password).apply()

            startActivity(Intent(applicationContext, UserSignedInActivity::class.java))
        }
    }
}
