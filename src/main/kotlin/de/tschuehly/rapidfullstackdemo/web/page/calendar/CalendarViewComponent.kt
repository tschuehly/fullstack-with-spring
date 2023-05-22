package de.tschuehly.rapidfullstackdemo.web.page.calendar

import de.tschuehly.rapidfullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class CalendarViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Calendar
    )
}