package de.tschuehly.rapidfullstackdemo.web.component.analytics.chart

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewContext
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