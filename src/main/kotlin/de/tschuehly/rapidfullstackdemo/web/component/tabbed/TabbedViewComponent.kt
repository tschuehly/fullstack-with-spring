package de.tschuehly.rapidfullstackdemo.web.component.tabbed

import de.tschuehly.rapidfullstackdemo.web.component.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.tabbed.alpineTab.AlpineTabViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class TabbedViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.TabbedContent,
        "alpineTabs" toProperty listOf(
            AlpineTabViewComponent.Tab("Tab1", "Lorem Ipsum"),
            AlpineTabViewComponent.Tab("Tab2", "Lorem Ipsum"),
        )
    )
}