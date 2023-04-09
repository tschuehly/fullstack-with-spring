package de.tschuehly.rapidfullstackdemo.core.person

import org.springframework.stereotype.Service

@Service
class PersonService {
    private val personData = mutableListOf<Person>()

    fun addPerson(person: Person){
        personData.add(person)
    }

    fun getPersonData() = personData
}

