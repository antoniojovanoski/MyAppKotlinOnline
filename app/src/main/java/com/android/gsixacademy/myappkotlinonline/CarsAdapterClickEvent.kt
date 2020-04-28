package com.android.gsixacademy.myappkotlinonline

sealed class CarsAdapterClickEvent {
    data class CarsAdapterItemClicked(var car: Car): CarsAdapterClickEvent()
}