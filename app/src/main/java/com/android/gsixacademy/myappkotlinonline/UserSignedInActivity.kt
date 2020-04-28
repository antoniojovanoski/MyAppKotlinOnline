package com.android.gsixacademy.myappkotlinonline

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_user_signed_in.*

class UserSignedInActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_signed_in)

       var mySharedPreferences = getSharedPreferences("KotlinBasicTutorialPreferences", Context.MODE_PRIVATE)
        var Myusername = mySharedPreferences.getString("userName","///")
        text_view_title.text = "Signed in user is $Myusername"

        button_log_out.setOnClickListener {
            mySharedPreferences.edit().clear().apply()
            onBackPressed()

        }
    }
}