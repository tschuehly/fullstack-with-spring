package de.tschuehly.rapidfullstackdemo.web.component

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.web.component.util.chart.ChartViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.person.form.PersonFormViewComponent
import de.tschuehly.rapidfullstackdemo.web.component.util.modal.ModalViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ComponentController(
    private val chartViewComponent: ChartViewComponent,
    private val analyticsService: AnalyticsService,
    private val modalViewComponent: ModalViewComponent,
    private val personFormViewComponent: PersonFormViewComponent
) {

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