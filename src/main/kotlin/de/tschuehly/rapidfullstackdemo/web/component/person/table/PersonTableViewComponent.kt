package de.tschuehly.rapidfullstackdemo.web.component.person.table

import de.tschuehly.rapidfullstackdemo.core.person.PersonService
import de.tschuehly.rapidfullstackdemo.web.component.util.advancedTable.AdvancedTableViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class PersonTableViewComponent(
    private val personService: PersonService
) {
    fun render(enableEdit: Boolean = false) = ViewContext(
        "personTable" toProperty AdvancedTableViewComponent.Table(
            listOf("Id","First Name", "Last Name", "Phone Number", "Email", "Birth Date"),
            personService.getPersonData().map { person ->
                person.getPersonAsList()
            },
            "/component/person/modal"
        )
    )
}