package com.android.gsixacademy.myappkotlinonline

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerViewActivity : AppCompatActivity() {

    var listCars: ArrayList<Car> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        listCars.add(Car("Mclaren", "MC Description", R.drawable.mclaren))
        listCars.add(Car("Honda", "Honda Description", R.drawable.honda_nsx))
        listCars.add(Car("Jaguar", "Jaguar Description ahsjakdskhdgsadjhadas asd a ds sadas dsad ad adsa da dsadaskdsajdasndasdasd sad asd asda dad", R.drawable.jaguar_f))
        listCars.add(Car("Mercedes", "Mercedes Description", R.drawable.mercedes_amg))
        listCars.add(Car("Audi", "Audi Description", R.drawable.audi_r))
        listCars.add(Car("Aston Martin", "Aston Martin Description", R.drawable.aston_martin))
        listCars.add(Car("Aston Martin 2", "Aston Martin Description 2", R.drawable.aston_martin1))
        listCars.add(Car("Maserati", "Maserati Description", R.drawable.maserati_granturismo))
        listCars.add(Car("Nissan", "Nissan Description", R.drawable.nissan))


        for(number in 0..100){
            listCars.add(Car("Nissan", "Nissan Description $number", R.drawable.nissan))
        }

        var carsAdapter: CarsAdapter = CarsAdapter(listCars){
             if (it is  CarsAdapterClickEvent.CarsAdapterItemClicked){
                 var carClicked = it.car
                  Toast.makeText(applicationContext,"${carClicked.title}",Toast.LENGTH_LONG).show()

                 var intent = Intent(applicationContext, CarDetailsActivity::class.java)
                 intent.putExtra("title",carClicked.title)
                 intent.putExtra("description",carClicked.description)
                 intent.putExtra("imageResource",carClicked.imageResource)
                 startActivity(intent)
            }
        }
        recylcer_view_activities.adapter = carsAdapter

    }

}