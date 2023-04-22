package de.tschuehly.rapidfullstackdemo.web.page.tabbed

import de.tschuehly.rapidfullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.util.alpineTab.AlpineTabViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class TabbedViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.TabbedContent,
        "alpineTabs" toProperty listOf(
            AlpineTabViewComponent.Tab(
                "AlpineTab1",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."
            ),
            AlpineTabViewComponent.Tab(
                "AlpineTab2",
                "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. "
            ),
        )
    )
}