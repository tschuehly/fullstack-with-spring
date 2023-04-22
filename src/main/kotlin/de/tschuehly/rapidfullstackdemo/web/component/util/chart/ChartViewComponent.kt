package de.tschuehly.rapidfullstackdemo.web.component.util.chart

import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class ChartViewComponent {
    fun render(
        barchartDetails: ChartDetails
    ) = ViewContext("barchartDetails" toProperty barchartDetails)

    class ChartDetails(
        val type: String,
        val width: Number,
        val height: Number,
        val chartLabel: String,
        val labels: List<String>,
        val data: List<Number>
    )
}