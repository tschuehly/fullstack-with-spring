package de.tschuehly.fullstackdemo.web.component

import de.tschuehly.fullstackdemo.web.component.analytics.chart.AnalyticsChartViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ComponentController(
    private val analyticsChartViewComponent: AnalyticsChartViewComponent
) {
    @GetMapping("/lineChartComponent")
    fun chartComponent(
        @RequestParam name: String
    ) = analyticsChartViewComponent.render(name)
}