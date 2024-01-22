package de.tschuehly.fullstackdemo.web.component.util.chart

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class ChartViewComponent {
    fun render(
        barchartDetails: ChartDetails
    ) = ChartCtx(barchartDetails)

    data class ChartCtx(val barchartDetails: ChartDetails) : ViewContext

    class ChartDetails(
        val type: String,
        val width: Number,
        val height: Number,
        val chartLabel: String,
        val labels: List<String>,
        val data: List<Number>
    )
}