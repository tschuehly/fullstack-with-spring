package de.tschuehly.rapidfullstackdemo.web.component.util.alpineTab

import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class AlpineTabViewComponent {
    fun render(tabs: List<Tab>) = ViewContext(
        "headerList" toProperty tabs.map { it.tabHeader },
        "contentList" toProperty tabs.map { it.tabContent }
    )

    class Tab(
        val tabHeader: String,
        val tabContent: String
    )
}