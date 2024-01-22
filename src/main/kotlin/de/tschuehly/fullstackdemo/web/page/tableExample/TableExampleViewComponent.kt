package de.tschuehly.fullstackdemo.web.page.tableExample

import de.tschuehly.fullstackdemo.web.component.person.table.PersonTableViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class TableExampleViewComponent(
    private val personTableViewComponent: PersonTableViewComponent
) {
    fun render() = TableExampleCtx(
        personTableViewComponent.render()
    )
    data class TableExampleCtx(val personTableViewComponent: ViewContext): ViewContext
}
