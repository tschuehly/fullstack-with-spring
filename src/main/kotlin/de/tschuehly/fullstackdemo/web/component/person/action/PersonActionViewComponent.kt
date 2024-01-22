package de.tschuehly.fullstackdemo.web.component.person.action

import de.tschuehly.fullstackdemo.core.person.Person
import de.tschuehly.fullstackdemo.core.person.PersonService
import de.tschuehly.spring.viewcomponent.core.action.PutViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import java.time.LocalDate

@ViewComponent
class PersonActionViewComponent(
    private val personService: PersonService
) {
    fun render(personId: Int? = null) = PersonActionCtx(
        getPerson(personId)
    )

    fun getPerson(personId: Int?): PersonFormDTO {
        if (personId != null) {
            personService.getPerson(personId).also { return PersonFormDTO(it) }
        }
        return PersonFormDTO(null, "", "", "", "", LocalDate.now())
    }

    @PutViewAction
    fun savePerson(personFormDTO: PersonFormDTO): ViewContext {
        val person = personService.savePerson(personFormDTO.convertToPerson())
        return render(person.id);
    }

    data class PersonActionCtx(val person: PersonFormDTO) : ViewContext

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