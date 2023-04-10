package de.tschuehly.rapidfullstackdemo.web.component.layout.sidebar


import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class SidebarViewComponent {

    fun render(activeTab: ActiveTab) = ViewContext(
        "activeTab" toProperty activeTab,
    )

    enum class ActiveTab(val displayName: String, val icon: String, val href: String) {
        Dashboard("Dashboard", "fa-tachometer-alt", dashboardHref),
        BlankPage("Blank Page", "fa-sticky-note", blankPageHref),
        Tables("Tables", "fa-table", tablesHref),
        Forms("Forms", "fa-align-left", formsHref),
        TabbedContent("Tabbed Content", "fa-tablet-alt", tabbedHref),
        Calendar("Calendar", "fa-calendar", calendarHref)

    }

    companion object {
        const val dashboardHref = "/"
        const val blankPageHref = "/blank-page"
        const val tablesHref = "/tables"
        const val formsHref = "/forms"
        const val tabbedHref = "/tabbed"
        const val calendarHref = "/calendar"
    }

}
