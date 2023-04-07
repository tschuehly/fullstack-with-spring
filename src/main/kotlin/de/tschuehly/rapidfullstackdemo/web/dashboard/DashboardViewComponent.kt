package de.tschuehly.rapidfullstackdemo.web.dashboard


import de.tschuehly.rapidfullstackdemo.web.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.layout.sidebar.SidebarViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class DashboardViewComponent {
    fun render() = ViewContext(
        "sidebarActiveTab" toProperty SidebarViewComponent.ActiveTab.Dashboard,
        "monthlyReportChart" toProperty ChartViewComponent.ChartDetails(
            "bar",
            400, 300,
            "# of Votes",
            listOf("Red", "Blue", "Yellow", "Green", "Purple", "Orange"),
            listOf(12, 19, 3, 5, 2, 3)
        ),
        "resolvedReportChart" toProperty ChartViewComponent.ChartDetails(
            "line",
            400, 300,
            "# of Votest",
            listOf("Red", "Blue", "Yellow", "Green", "Purple", "Orange"),
            listOf(12, 19, 3, 5, 2, 3)
        )
    )
}