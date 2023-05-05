package de.tschuehly.rapidfullstackdemo.web.component.analytics.chart

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

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