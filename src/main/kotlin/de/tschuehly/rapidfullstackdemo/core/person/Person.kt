package de.tschuehly.rapidfullstackdemo.core.person

import java.util.*


class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val birthDate: Date
) {

    fun getPersonAsList() = listOf(firstName, lastName, phoneNumber, email, birthDate.toString())

}

