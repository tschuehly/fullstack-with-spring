package de.tschuehly.fullstackdemo.web.component.analytics.chart

import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class AnalyticsChartViewComponent(
    private val analyticsService: AnalyticsService
) {
    fun render(name: String) = ViewContext(
        "chartDetails" toProperty ChartViewComponent.ChartDetails(
            "line",
            400,
            200,
            name,
            analyticsService.getTimeStampsFor(name),
            analyticsService.getComputeTimesFor(name)
        )
    )
}