package de.tschuehly.fullstackdemo.web.page

import de.tschuehly.fullstackdemo.web.component.person.table.PersonTableViewComponent
import de.tschuehly.fullstackdemo.web.page.calendar.CalendarViewComponent
import de.tschuehly.fullstackdemo.web.page.dashboard.DashboardViewComponent
import de.tschuehly.fullstackdemo.web.page.form.FormViewComponent
import de.tschuehly.fullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.fullstackdemo.web.page.login.LoginViewComponent
import de.tschuehly.fullstackdemo.web.page.register.RegisterViewComponent
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
    private val personTableViewComponent: PersonTableViewComponent,
    private val registerViewComponent: RegisterViewComponent,
    private val loginViewComponent: LoginViewComponent
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

    @GetMapping("/login")
    fun login() = loginViewComponent.render()

    @GetMapping("/register")
    fun register() = registerViewComponent.render()

}








