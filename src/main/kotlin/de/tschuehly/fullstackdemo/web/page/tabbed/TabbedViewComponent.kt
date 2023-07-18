package de.tschuehly.fullstackdemo.web.page.tabbed

import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.fullstackdemo.web.component.util.alpineTab.AlpineTabViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class TabbedViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.TabbedContent,
        "alpineTabs" toProperty listOf(
            AlpineTabViewComponent.Tab(
                "AlpineTab1",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor " +
                        "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."
            ),
            AlpineTabViewComponent.Tab(
                "AlpineTab2",
                "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. "
            ),
        )
    )
}