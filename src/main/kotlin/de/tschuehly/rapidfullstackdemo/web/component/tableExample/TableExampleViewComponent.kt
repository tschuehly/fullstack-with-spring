package de.tschuehly.rapidfullstackdemo.web.component.tableExample

import de.tschuehly.rapidfullstackdemo.core.person.PersonService
import de.tschuehly.rapidfullstackdemo.web.component.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.tableExample.advancedTable.AdvancedTableViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class TableExampleViewComponent(
    private val personService: PersonService
) {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Tables,
        "advancedTable" toProperty AdvancedTableViewComponent.Table(
            listOf("Id","First Name", "Last Name", "Phone Number", "Email", "Birth Date"),
            personService.getPersonData().map { person ->
                person.getPersonAsList()
            },
            "/modal/person"
        )
    )
}
