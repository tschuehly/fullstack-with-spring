package de.tschuehly.rapidfullstackdemo.web.component

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.web.component.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.dashboard.DashboardViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.form.FormViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class Router(
    private val dashboardViewComponent: DashboardViewComponent,
    private val chartViewComponent: ChartViewComponent,
    private val formViewComponent: FormViewComponent,
    private val analyticsService: AnalyticsService
) {
    @GetMapping("/")
    fun home() = dashboardViewComponent.render()

    @GetMapping("/forms")
    fun forms() = formViewComponent.render()

    @GetMapping("/lineChartComponent")
    fun chartComponent(
        @RequestParam name: String
    ) = chartViewComponent.render(
        ChartViewComponent.ChartDetails(
            "line",
            400,
            200,
            name,
            analyticsService.getTimeStampsFor(name),
            analyticsService.getComputeTimesFor(name)
        )
    )
}








