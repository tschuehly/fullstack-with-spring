package de.tschuehly.fullstackdemo.web.page

import de.tschuehly.fullstackdemo.core.analytics.AnalyticsService
import de.tschuehly.fullstackdemo.core.person.PersonService
import de.tschuehly.fullstackdemo.web.page.dashboard.DashboardViewComponent
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