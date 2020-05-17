package com.android.gsixacademy.myappkotlinonline.movies

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.gsixacademy.myappkotlinonline.R
import com.android.gsixacademy.myappkotlinonline.api.ServiceBuilder
import com.android.gsixacademy.myappkotlinonline.api.TheMovieDbApi
import com.android.gsixacademy.myappkotlinonline.models.PopularMovies
import kotlinx.android.synthetic.main.activity_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopularMoviesActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val request = ServiceBuilder.buildService(TheMovieDbApi::class.java)
        val call = request.getPopularMovies("8dd3a40cdacd660d79bce7c46bad942e")

        call.enqueue(object : Callback<PopularMovies> {
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {
                if (response.isSuccessful){
                    val popularMovies = response.body()
                    val moviesList = popularMovies?.results

                    if(moviesList!=null){
                        var moviesAdapter = MoviesAdapter(moviesList){}
                        recylcer_view_movies.adapter = moviesAdapter
                    }
                }
            }
            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                // show the error
            }
        })
    }
}