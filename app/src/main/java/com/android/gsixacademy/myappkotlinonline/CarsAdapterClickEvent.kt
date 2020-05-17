package com.android.gsixacademy.myappkotlinonline

import com.android.gsixacademy.myappkotlinonline.models.Car

sealed class CarsAdapterClickEvent {
    data class CarsAdapterItemClicked(var car: Car): CarsAdapterClickEvent()
}