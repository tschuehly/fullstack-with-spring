package de.tschuehly.fullstackdemo.web.page.dashboard


import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.web.component.person.table.PersonTableViewComponent
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent.ChartCtx
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class DashboardViewComponent(
    private val analyticsService: AnalyticsService,
    private val chartViewComponent: ChartViewComponent,
    private val personTableViewComponent: PersonTableViewComponent
) {
    fun render() = DashboardCtx(
        chartViewComponent.render(
            ChartViewComponent.ChartDetails(
                "bar",
                400, 200,
                "Number of Requests",
                analyticsService.getLabelList(),
                analyticsService.getRequestCountList()
            )
        ),
        analyticsService.getLabelList(),
        personTableViewComponent.render()
    )

    data class DashboardCtx(
        val requestChartVC: ChartCtx,
        val renderTimeLabelList: List<String>,
        val personTableVC: ViewContext
    ) : ViewContext


}