package de.tschuehly.fullstackdemo.web.page.layout.header


import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent.ActiveTab
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class HeaderViewComponent(
) {
    fun render(activeTab: ActiveTab?) =
        HeaderCtx(
            activeTab,
            ActiveTab.values().toList()
        )

    data class HeaderCtx(
        val activeTab: ActiveTab?,
        val tabs: List<ActiveTab>
    ) : ViewContext
}