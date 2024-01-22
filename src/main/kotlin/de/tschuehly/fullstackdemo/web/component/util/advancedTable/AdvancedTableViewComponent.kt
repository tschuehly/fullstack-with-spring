package de.tschuehly.fullstackdemo.web.component.util.advancedTable

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class AdvancedTableViewComponent {
    fun render(table: Table) = AdvancedTableCtx(
        table
    )

    data class Table(
        val headerList: List<String>,
        val tableData: List<List<String>>,
        val editComponentLink: String = ""
    )
    data class AdvancedTableCtx(
        val table: Table
    ):ViewContext
}