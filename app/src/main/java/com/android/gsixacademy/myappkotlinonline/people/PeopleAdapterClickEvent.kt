package com.android.gsixacademy.myappkotlinonline.people

import com.android.gsixacademy.myappkotlinonline.models.PersonResult

sealed class PeopleAdapterClickEvent {
    data class PeopleAdapterItemClicked(var personResult: PersonResult): PeopleAdapterClickEvent()
}