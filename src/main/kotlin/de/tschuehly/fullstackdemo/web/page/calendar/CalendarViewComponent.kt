package de.tschuehly.fullstackdemo.web.page.calendar

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class CalendarViewComponent(
){
    fun render() = CalendarCtx()
    class CalendarCtx : ViewContext
}