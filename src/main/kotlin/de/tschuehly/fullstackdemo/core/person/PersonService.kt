package de.tschuehly.fullstackdemo.core.person

import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.NoSuchElementException
import kotlin.random.Random

@Service
class PersonService {
    private val personData = mutableListOf(
        Person(1,"Thomas","Schühly","123456","tschuehly@outlook.com", LocalDate.now())
    )

    fun savePerson(person: Person){
        if(person.id != null) {
            personData.replaceAll {
                if(it.id == person.id) person else it
            }
            return
        }
        person.id = Random.nextInt()
        personData.add(person)

    }


    fun getPerson(personId: Int): Person {
        return personData.find { it.id == personId } ?: throw NoSuchElementException("No Person with Id: $personId found")
    }

    fun getPersonData() = personData
}

