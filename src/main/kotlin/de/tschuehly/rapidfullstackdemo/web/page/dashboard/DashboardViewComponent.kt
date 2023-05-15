package de.tschuehly.rapidfullstackdemo.web.page.dashboard


import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.core.person.PersonService
import de.tschuehly.rapidfullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.page.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.util.table.TableViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class DashboardViewComponent(
    private val analyticsService: AnalyticsService,
    private val personService: PersonService
) {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Dashboard,
        "requestChart" toProperty ChartViewComponent.ChartDetails(
            "bar",
            400, 200,
            "Number of Requests",
            analyticsService.getLabelList(),
            analyticsService.getRequestCountList()
        ),
        "renderTimeLabelList" toProperty analyticsService.getLabelList(),
        "personTable" toProperty TableViewComponent.Table(
            listOf("ID","First Name", "Last Name", "Phone Number", "Email", "Birth Date"),
            personService.getPersonData().map { person ->
                person.getPersonAsList()
            }
        )
    )


}