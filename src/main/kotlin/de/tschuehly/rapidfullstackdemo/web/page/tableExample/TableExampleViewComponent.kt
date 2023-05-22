package de.tschuehly.rapidfullstackdemo.web.page.tableExample

import de.tschuehly.rapidfullstackdemo.core.person.PersonService
import de.tschuehly.rapidfullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.util.advancedTable.AdvancedTableViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class TableExampleViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Tables,

    )
}
