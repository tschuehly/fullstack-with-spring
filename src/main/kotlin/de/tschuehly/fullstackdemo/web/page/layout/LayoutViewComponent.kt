package de.tschuehly.fullstackdemo.web.page.layout

import de.tschuehly.fullstackdemo.web.page.layout.header.HeaderViewComponent
import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class LayoutViewComponent(
    private val sidebarViewComponent: SidebarViewComponent,
    private val headerViewComponent: HeaderViewComponent
) {

    fun render(
        activeTab: SidebarViewComponent.ActiveTab?,
        nestedViewComponent: ViewContext
    ) = ViewContext(
        "sidebarViewComponent" toProperty sidebarViewComponent.render(activeTab),
        "headerViewComponent" toProperty headerViewComponent.render(activeTab),
        "nestedViewComponent" toProperty nestedViewComponent
    )
}