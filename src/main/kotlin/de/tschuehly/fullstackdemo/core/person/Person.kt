package de.tschuehly.fullstackdemo.core.person

import java.time.LocalDate


class Person(
    var id: Int?,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val birthDate: LocalDate
) {

    fun getPersonAsList() = listOf(id.toString(),firstName, lastName, phoneNumber, email, birthDate.toString())

}

