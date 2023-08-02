package de.tschuehly.fullstackdemo.web.component.analytics.chart

import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class AnalyticsChartViewComponent(
    private val analyticsService: AnalyticsService,
    private val chartViewComponent: ChartViewComponent
) {
    fun render(name: String) = ViewContext(
        "chartViewComponent" toProperty chartViewComponent.render(
            ChartViewComponent.ChartDetails(
                "line",
                400,
                200,
                name,
                analyticsService.getTimeStampsFor(name),
                analyticsService.getComputeTimesFor(name)
            )
        )
    )
}