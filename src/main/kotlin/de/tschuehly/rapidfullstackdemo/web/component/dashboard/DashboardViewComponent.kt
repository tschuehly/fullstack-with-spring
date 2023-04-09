package de.tschuehly.rapidfullstackdemo.web.component.dashboard


import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.core.person.PersonService
import de.tschuehly.rapidfullstackdemo.web.component.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.layout.sidebar.SidebarViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.table.TableViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

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
            listOf("First Name", "Last Name", "Phone Number", "Email", "Birth Date"),
            personService.getPersonData().map { person ->
                person.getPersonAsList()
            }
        )
    )


}