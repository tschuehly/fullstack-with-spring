package de.tschuehly.rapidfullstackdemo.web.component.form.person

import de.tschuehly.rapidfullstackdemo.core.person.Person
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import java.util.*

@ViewComponent
class PersonFormViewComponent {
    fun render() = ViewContext()

    class PersonFormDTO(
        val firstName: String,
        val lastName: String,
        val phoneNumber: String,
        val email: String,
        val birthDate: Date
    ){
        fun convertToPerson() = Person(
            this.firstName,
            this.lastName,
            this.phoneNumber,
            this.email,
            this.birthDate
        )
    }
}