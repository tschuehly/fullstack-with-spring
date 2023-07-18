package de.tschuehly.fullstackdemo.web.component.util.table

import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class TableViewComponent {
    fun render(table: Table) = ViewContext(
        "headerList" toProperty table.headerList,
        "tableData" toProperty table.data
    )

    class Table(
        val headerList: List<String>,
        val data: List<List<String>>

    )
}