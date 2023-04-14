package de.tschuehly.rapidfullstackdemo.web.component.form.person

import de.tschuehly.rapidfullstackdemo.common.ApiConfig
import de.tschuehly.rapidfullstackdemo.core.person.Person
import de.tschuehly.rapidfullstackdemo.core.person.PersonService
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty
import java.time.LocalDate

@ViewComponent
class PersonFormViewComponent(
    private val personService: PersonService
) {
    fun render(personId: Int?) = ViewContext(
        "personPost" toProperty ApiConfig.Person.put,
        "person" toProperty getPerson(personId)
    )

    fun getPerson(personId: Int?): PersonFormDTO {
        if (personId != null) {
            personService.getPerson(personId).also { return PersonFormDTO(it) }
        }
        return PersonFormDTO(null,"", "", "", "", LocalDate.now())
    }

    class PersonFormDTO(
        val id: Int?,
        val firstName: String,
        val lastName: String,
        val phoneNumber: String,
        val email: String,
        val birthDate: LocalDate
    ) {

        constructor(person: Person) : this(
            person.id,
            person.firstName,
            person.lastName,
            person.phoneNumber,
            person.email,
            person.birthDate
        )

        fun convertToPerson() = Person(
            this.id,
            this.firstName,
            this.lastName,
            this.phoneNumber,
            this.email,
            this.birthDate
        )
    }
}