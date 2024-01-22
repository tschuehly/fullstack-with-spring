package de.tschuehly.fullstackdemo.web.page.layout.sidebar


import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class SidebarViewComponent {

    fun render(activeTab: ActiveTab?): ViewContext {
        return SidebarCtx(
            activeTab, ActiveTab.values().toList()
        )
    }

    data class SidebarCtx(
        val activeTab: ActiveTab?,
        val activeTabsList: List<ActiveTab>
    ): ViewContext

    enum class ActiveTab(val displayName: String, val icon: String, val href: String) {
        Dashboard("Dashboard", "fa-tachometer-alt", dashboardHref),
        Tables("Tables", "fa-table", tablesHref),
        Forms("Forms", "fa-align-left", formsHref),
        TabbedContent("Tabbed Content", "fa-tablet-alt", tabbedHref),
        Calendar("Calendar", "fa-calendar", calendarHref),

    }

    companion object {
        const val dashboardHref = "/"
        const val tablesHref = "/tables"
        const val formsHref = "/forms"
        const val tabbedHref = "/tabbed"
        const val calendarHref = "/calendar"
    }

}
