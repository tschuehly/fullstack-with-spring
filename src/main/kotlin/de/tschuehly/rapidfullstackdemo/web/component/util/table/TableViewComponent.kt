package de.tschuehly.rapidfullstackdemo.web.component.util.table

import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

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