package de.tschuehly.rapidfullstackdemo.web.layout.sidebar


import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class SidebarViewComponent {
    fun render(activeTab: ActiveTab) = ViewContext(
        "activeTab" toProperty activeTab
    )

    enum class ActiveTab {
        Dashboard, BlankPage, Tables, Forms, TabbedContent, Calendar
    }
}