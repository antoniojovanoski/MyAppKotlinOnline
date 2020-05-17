package com.android.gsixacademy.myappkotlinonline.movies

import com.android.gsixacademy.myappkotlinonline.models.Car
import com.android.gsixacademy.myappkotlinonline.models.MovieResult

sealed class MoviesAdapterClickEvent {
    data class MoviesAdapterItemClicked(var movieResult : MovieResult): MoviesAdapterClickEvent()
}