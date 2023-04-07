package de.tschuehly.rapidfullstackdemo.web.component.dashboard


import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.web.component.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.layout.sidebar.SidebarViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class DashboardViewComponent(
    private val analyticsService: AnalyticsService
) {
    fun render(): ViewContext {
        val firstComponent = analyticsService.getLabelList().firstOrNull() ?: ""
        return ViewContext(
            "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Dashboard,
            "monthlyReportChart" toProperty ChartViewComponent.ChartDetails(
                "bar",
                400, 200,
                "Number of Requests",
                analyticsService.getLabelList(),
                analyticsService.getRequestCountList()
            ),
            "labelList" toProperty analyticsService.getLabelList(),
            "resolvedReportChart" toProperty ChartViewComponent.ChartDetails(
                "line",
                400, 200,
                "Compute Time of Component: ${firstComponent}",
                analyticsService.getTimeStampsFor(firstComponent),
                analyticsService.getComputeTimesFor(firstComponent)
            )
        )
    }}