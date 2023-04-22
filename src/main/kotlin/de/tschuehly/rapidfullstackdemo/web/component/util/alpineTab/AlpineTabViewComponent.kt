package de.tschuehly.rapidfullstackdemo.web.component.util.alpineTab

import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

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