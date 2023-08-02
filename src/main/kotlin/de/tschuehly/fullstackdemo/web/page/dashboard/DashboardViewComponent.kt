package de.tschuehly.fullstackdemo.web.page.dashboard


import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.core.person.Person
import de.tschuehly.fullstackdemo.core.person.PersonService
import de.tschuehly.fullstackdemo.web.component.person.table.PersonTableViewComponent
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.fullstackdemo.web.component.util.table.TableViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class DashboardViewComponent(
    private val analyticsService: AnalyticsService,
    private val personService: PersonService,
    private val chartViewComponent: ChartViewComponent,
    private val personTableViewComponent: PersonTableViewComponent
) {
    fun render() = ViewContext(
        "requestChartVC" toProperty chartViewComponent.render(
            ChartViewComponent.ChartDetails(
                "bar",
                400, 200,
                "Number of Requests",
                analyticsService.getLabelList(),
                analyticsService.getRequestCountList()
            )
        ),
        "renderTimeLabelList" toProperty analyticsService.getLabelList(),
        "personTableVC" toProperty personTableViewComponent.render()
    )


}