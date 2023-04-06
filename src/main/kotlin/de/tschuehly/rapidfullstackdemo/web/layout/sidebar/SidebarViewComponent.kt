package de.tschuehly.rapidfullstackdemo.web.layout.sidebar


import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class SidebarViewComponent {
    fun render(activeTab: ActiveTab) = ViewContext(
        "activeTab" toProperty activeTab,
    )

    enum class ActiveTab(val displayName: String, val icon: String, val href: String) {
        Dashboard("Dashboard", "fa-tachometer-alt", "/"),
        BlankPage("Blank Page", "fa-sticky-note", "/blank-page"),
        Tables("Tables", "fa-table", "/tables"),
        Forms("Forms", "fa-align-left", "/forms"),
        TabbedContent("Tabbed Content", "fa-tablet-alt", "/tabbed"),
        Calendar("Calendar", "fa-calendar", "/calendar")

    }
}
