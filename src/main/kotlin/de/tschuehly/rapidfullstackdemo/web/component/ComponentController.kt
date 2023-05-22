package de.tschuehly.rapidfullstackdemo.web.component

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.web.component.analytics.chart.AnalyticsChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.util.modal.ModalViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
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