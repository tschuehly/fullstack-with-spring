package de.tschuehly.rapidfullstackdemo.web.page

import de.tschuehly.rapidfullstackdemo.web.page.calendar.CalendarViewComponent
import de.tschuehly.rapidfullstackdemo.web.page.dashboard.DashboardViewComponent
import de.tschuehly.rapidfullstackdemo.web.page.form.FormViewComponent
import de.tschuehly.rapidfullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.page.tabbed.TabbedViewComponent
import de.tschuehly.rapidfullstackdemo.web.page.tableExample.TableExampleViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PageController(
    private val dashboardViewComponent: DashboardViewComponent,
    private val calendarViewComponent: CalendarViewComponent,
    private val tabbedViewComponent: TabbedViewComponent,
    private val tableExampleViewComponent: TableExampleViewComponent,
    private val formViewComponent: FormViewComponent,
) {
    @GetMapping(SidebarViewComponent.dashboardHref)
    fun home() = dashboardViewComponent.render()

    @GetMapping(SidebarViewComponent.formsHref)
    fun forms() = formViewComponent.render()

    @GetMapping(SidebarViewComponent.calendarHref)
    fun calendar() = calendarViewComponent.render()

    @GetMapping(SidebarViewComponent.tabbedHref)
    fun tabs() = tabbedViewComponent.render()


    @GetMapping(SidebarViewComponent.tablesHref)
    fun tableExample() = tableExampleViewComponent.render()


}








