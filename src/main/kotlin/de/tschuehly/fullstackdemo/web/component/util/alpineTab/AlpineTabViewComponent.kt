package de.tschuehly.fullstackdemo.web.component.util.alpineTab

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class AlpineTabViewComponent {
    fun render(tabs: List<Tab>) = AlpineTabCtx(
        tabs.map { it.tabHeader },
        tabs.map { it.tabContent }
    )
    class Tab(
        val tabHeader: String,
        val tabContent: String
    )
    data class AlpineTabCtx(
        val headerList: List<String>,
        val contentList: List<String>
    ):ViewContext
}