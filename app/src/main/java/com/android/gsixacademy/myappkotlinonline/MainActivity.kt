package com.android.gsixacademy.myappkotlinonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity","CalculatorActivity","TodoListActivity","RecyclerViewActivity","LoginActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load("https://tinyjpg.com/images/social/website.jpg").fit().into(image_view_background)


        var activitiesAdapter: ArrayAdapter<String> =  ArrayAdapter(this,android.R.layout.simple_list_item_1,listActivities)
        list_view_activities.adapter = activitiesAdapter

        list_view_activities.setOnItemClickListener { adapterView, view, i, l -> var className = listActivities[i]

           when(className) {
    "RelativeLayoutActivity" -> startActivity(Intent(applicationContext, RelativeLayoutActivity::class.java))

    "CalculatorActivity" -> startActivity(Intent(applicationContext, CalculatorActivity::class.java))

    "TodoListActivity" -> startActivity(Intent(applicationContext, TodoListActivity::class.java))

    "RecyclerViewActivity" -> startActivity(Intent(applicationContext, RecyclerViewActivity::class.java))
               "LoginActivity" -> startActivity(Intent(applicationContext, LoginActivity::class.java))
}

            Toast.makeText(applicationContext,className,Toast.LENGTH_LONG).show()
        }


    }
}
