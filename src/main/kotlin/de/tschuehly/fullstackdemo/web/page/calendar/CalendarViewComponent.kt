package de.tschuehly.fullstackdemo.web.page.calendar

import de.tschuehly.fullstackdemo.web.page.calendar.eventModal.EventModalViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class CalendarViewComponent(
    private val eventModalViewComponent: EventModalViewComponent
){
    fun render() = ViewContext(
        "eventModalViewComponent" toProperty eventModalViewComponent.render()
    )
}