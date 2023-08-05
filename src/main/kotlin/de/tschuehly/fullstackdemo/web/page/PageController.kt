package de.tschuehly.fullstackdemo.web.page

import de.tschuehly.fullstackdemo.web.page.calendar.CalendarViewComponent
import de.tschuehly.fullstackdemo.web.page.dashboard.DashboardViewComponent
import de.tschuehly.fullstackdemo.web.page.form.FormViewComponent
import de.tschuehly.fullstackdemo.web.page.layout.LayoutViewComponent
import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent.ActiveTab
import de.tschuehly.fullstackdemo.web.page.tabbed.TabbedViewComponent
import de.tschuehly.fullstackdemo.web.page.tableExample.TableExampleViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PageController(
    private val dashboardViewComponent: DashboardViewComponent,
    private val calendarViewComponent: CalendarViewComponent,
    private val tabbedViewComponent: TabbedViewComponent,
    private val tableExampleViewComponent: TableExampleViewComponent,
    private val formViewComponent: FormViewComponent,
    private val layoutViewComponent: LayoutViewComponent
) {
    @GetMapping(SidebarViewComponent.dashboardHref)
    fun home() = layoutViewComponent.render(
        ActiveTab.Dashboard,
        dashboardViewComponent.render()
    )

    @GetMapping(SidebarViewComponent.tablesHref)
    fun tableExample() = layoutViewComponent.render(
        ActiveTab.Tables,
        tableExampleViewComponent.render()
    )

    @GetMapping(SidebarViewComponent.formsHref)
    fun forms() = layoutViewComponent.render(
        ActiveTab.Forms,
        formViewComponent.render()
    )

    @GetMapping(SidebarViewComponent.tabbedHref)
    fun tabs() = layoutViewComponent.render(
        ActiveTab.TabbedContent,
        tabbedViewComponent.render()
    )

    @GetMapping(SidebarViewComponent.calendarHref)
    fun calendar() = layoutViewComponent.render(
        ActiveTab.Calendar,
        calendarViewComponent.render()
    )

}








