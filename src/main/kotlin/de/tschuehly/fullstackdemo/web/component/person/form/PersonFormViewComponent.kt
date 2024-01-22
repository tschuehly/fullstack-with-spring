package de.tschuehly.fullstackdemo.web.component.person.form

import de.tschuehly.fullstackdemo.common.ApiConfig
import de.tschuehly.fullstackdemo.core.person.Person
import de.tschuehly.fullstackdemo.core.person.PersonService
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import java.time.LocalDate

@ViewComponent
class PersonFormViewComponent(
    private val personService: PersonService
) {
    fun render(personId: Int? = null) = PersonFormCtx(
        ApiConfig.Person.put,
        getPerson(personId)
    )

    fun getPerson(personId: Int?): PersonFormDTO {
        if (personId != null) {
            personService.getPerson(personId).also { return PersonFormDTO(it) }
        }
        return PersonFormDTO(null, "", "", "", "", LocalDate.now())
    }

    data class PersonFormCtx(val personPost: String, val person: PersonFormDTO) : ViewContext

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