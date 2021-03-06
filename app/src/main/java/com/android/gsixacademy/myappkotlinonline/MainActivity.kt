package com.android.gsixacademy.myappkotlinonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.gsixacademy.myappkotlinonline.movies.PopularMoviesActivity
import com.android.gsixacademy.myappkotlinonline.people.PopularPeopleActivity
import com.android.gsixacademy.myappkotlinonline.search.SearchMoviesActivity
import com.android.gsixacademy.myappkotlinonline.search.SearchPeopleActivity

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

var listActivities: ArrayList<String> = arrayListOf("RelativeLayoutActivity","CalculatorActivity","TodoListActivity","RecyclerViewActivity","PopularMoviesActivity","LoginActivity","PopularPeopleActivity","SearchMoviesActivity","SearchPeopleActivity")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load("https://i.pinimg.com/originals/f7/15/5f/f7155f58160612556d1259cf6aa33895.jpg").fit().into(image_view_background)


        var activitiesAdapter: ArrayAdapter<String> =  ArrayAdapter(this,android.R.layout.simple_list_item_1,listActivities)
        list_view_activities.adapter = activitiesAdapter

        list_view_activities.setOnItemClickListener { adapterView, view, i, l -> var className = listActivities[i]

           when(className) {
    "RelativeLayoutActivity" -> startActivity(Intent(applicationContext, RelativeLayoutActivity::class.java))

    "CalculatorActivity" -> startActivity(Intent(applicationContext, CalculatorActivity::class.java))

               "TodoListActivity" -> startActivity(Intent(applicationContext, TodoListActivity::class.java))

               "RecyclerViewActivity" -> startActivity(Intent(applicationContext, RecyclerViewActivity::class.java))
                "LoginActivity" -> startActivity(Intent(applicationContext, LoginActivity::class.java))

               "PopularMoviesActivity" -> startActivity(Intent(applicationContext, PopularMoviesActivity::class.java))
               "PopularPeopleActivity" -> startActivity(Intent(applicationContext, PopularPeopleActivity::class.java))
               "SearchMoviesActivity" -> startActivity(Intent(applicationContext, SearchMoviesActivity::class.java))
               "SearchPeopleActivity" -> startActivity(Intent(applicationContext, SearchPeopleActivity::class.java))
}

            Toast.makeText(applicationContext,className,Toast.LENGTH_LONG).show()
        }


    }
}
