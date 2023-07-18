package de.tschuehly.fullstackdemo.web.component.util.advancedTable

import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class AdvancedTableViewComponent {
    fun render(table: Table) = ViewContext(
        "headerList" toProperty table.headerList,
        "tableData" toProperty table.data,
        "editComponentLink" toProperty table.editComponentLink,
    )

    class Table(
        val headerList: List<String>,
        val data: List<List<String>>,
        val editComponentLink: String = ""
    )
}