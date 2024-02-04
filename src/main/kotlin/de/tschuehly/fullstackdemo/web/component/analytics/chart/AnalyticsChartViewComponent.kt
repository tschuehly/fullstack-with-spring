package de.tschuehly.fullstackdemo.web.component.analytics.chart

import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class AnalyticsChartViewComponent(
    private val analyticsService: AnalyticsService,
    private val chartViewComponent: ChartViewComponent
) {
    fun render(name: String): AnalyticsChartContext {
        return AnalyticsChartContext(
            chartViewComponent.render(
                ChartViewComponent.ChartDetails(
                    type = "line",
                    width = 400,
                    height = 200,
                    chartLabel = name,
                    labels = analyticsService.getTimeStampsFor(name),
                    data = analyticsService.getComputeTimesFor(name)
                )
            )
        )
    }
    data class AnalyticsChartContext(
        val chartViewComponent: ViewContext
    ) : ViewContext
}