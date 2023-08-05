package de.tschuehly.fullstackdemo.web.component.person.table

import de.tschuehly.fullstackdemo.core.person.PersonService
import de.tschuehly.fullstackdemo.web.component.util.advancedTable.AdvancedTableViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class PersonTableViewComponent(
    private val personService: PersonService,
    private val advancedTableViewComponent: AdvancedTableViewComponent
) {
    fun render(enableEdit: Boolean = false): ViewContext {
        val personList = personService.getPersonData().map { person ->
            person.getPersonAsList()
        }
        val personTable = advancedTableViewComponent.render(
            AdvancedTableViewComponent.Table(
                listOf("Id", "First Name", "Last Name", "Phone Number", "Email", "Birth Date"),
                personList,
                "/component/person/modal"
            )
        )
        return ViewContext(
            "personTable" toProperty personTable
        )
    }
}