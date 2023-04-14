package de.tschuehly.rapidfullstackdemo.core.person

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import java.util.*


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

