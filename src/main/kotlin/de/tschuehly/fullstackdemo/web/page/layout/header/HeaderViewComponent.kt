package de.tschuehly.fullstackdemo.web.page.layout.header


import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class HeaderViewComponent {
    fun render(activeTab: SidebarViewComponent.ActiveTab?) =
        ViewContext("activeTab" toProperty activeTab)
}