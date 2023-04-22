package de.tschuehly.rapidfullstackdemo.web.page

import de.tschuehly.rapidfullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.rapidfullstackdemo.core.person.PersonService
import de.tschuehly.rapidfullstackdemo.web.page.dashboard.DashboardViewComponent
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class DashboardViewComponentTest {

    fun dashboardRenders(){
        val analyticsService = AnalyticsService()
        val personService = PersonService()
        val dashboard = DashboardViewComponent(analyticsService, personService)
        dashboard.render()

    }
}