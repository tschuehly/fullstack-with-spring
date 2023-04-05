package de.tschuehly.rapidfullstackdemo.web.dashboard


import de.tschuehly.rapidfullstackdemo.web.layout.sidebar.SidebarViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class DashboardViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Dashboard
    )
}