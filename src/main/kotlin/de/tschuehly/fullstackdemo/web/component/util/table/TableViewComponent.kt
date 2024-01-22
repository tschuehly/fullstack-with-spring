package de.tschuehly.fullstackdemo.web.component.util.table

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class TableViewComponent {
    fun render(table: TableCtx) = table

    data class TableCtx(
        val headerList: List<String>,
        val tableData: List<List<String>>

    ) : ViewContext
}