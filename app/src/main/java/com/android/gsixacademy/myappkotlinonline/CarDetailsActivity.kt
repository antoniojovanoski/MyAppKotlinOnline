package com.android.gsixacademy.myappkotlinonline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class CarDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_details)

        var myTitle = intent.getStringExtra("title")
        var myDescription = intent.getStringExtra("description")
        var myImageResource = intent.getIntExtra("imageResource", 0)


    }
}