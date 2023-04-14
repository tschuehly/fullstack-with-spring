package de.tschuehly.rapidfullstackdemo.web.component.tableExample.advancedTable

import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

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