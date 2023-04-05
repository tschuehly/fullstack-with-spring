package de.tschuehly.rapidfullstackdemo.web

import de.tschuehly.rapidfullstackdemo.web.dashboard.DashboardViewComponent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Router(private val dashboardViewComponent: DashboardViewComponent) {
    @GetMapping("/")
    fun home() = dashboardViewComponent.render()
}