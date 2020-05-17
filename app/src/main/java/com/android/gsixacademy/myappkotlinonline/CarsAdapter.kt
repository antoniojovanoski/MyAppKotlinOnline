package com.android.gsixacademy.myappkotlinonline

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gsixacademy.myappkotlinonline.models.Car
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_list_item.view.*

class CarsAdapter(val itemList: ArrayList<Car>, val carsAdapterClickEvent: (CarsAdapterClickEvent) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_list_item, parent, false))
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(itemList[position], position)
    }
    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view){
        fun bindData(itemModel: Car, position: Int) {
            Picasso.get().load(itemModel.imageResource).fit().fit().into(itemView.image_view_car)
//            itemView.image_view_car.setImageResource(itemModel.imageResource)
            itemView.text_view_title.text = itemModel.title
            itemView.text_view_description.text = itemModel.description
            itemView.image_view_favorite.setOnClickListener {
                var mySharedPreferences = itemView.image_view_favorite.context.getSharedPreferences("MyFavorites", Context.MODE_PRIVATE)
                if(mySharedPreferences.contains("myFavorite_$position")) {
                    mySharedPreferences.edit().remove("myFavorite_$position").apply()
                    Picasso.get().load(R.drawable.icon_star_white).fit().fit()
                        .into(itemView.image_view_favorite)
                }else{
                    mySharedPreferences.edit().putInt("myFavorite_$position", position).apply()
                    Picasso.get().load(R.drawable.icon_star).fit().fit()
                        .into(itemView.image_view_favorite)
                }
            }
            var mySharedPreferences = itemView.image_view_favorite.context.getSharedPreferences("MyFavorites", Context.MODE_PRIVATE)
            if(mySharedPreferences.contains("myFavorite_$position")) {
                Picasso.get().load(R.drawable.icon_star).fit().fit()
                    .into(itemView.image_view_favorite)
            }else{
                Picasso.get().load(R.drawable.icon_star_white).fit().fit()
                    .into(itemView.image_view_favorite)
            }
            itemView.constraint_car_main.setOnClickListener {
                carsAdapterClickEvent.invoke(CarsAdapterClickEvent.CarsAdapterItemClicked(itemModel))
            }

        }
    }
}