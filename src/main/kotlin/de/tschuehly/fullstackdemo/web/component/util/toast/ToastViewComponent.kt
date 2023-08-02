package de.tschuehly.fullstackdemo.web.component.util.toast

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class ToastViewComponent {
    fun render(message: String, durationMs: Int) = ViewContext(
        "message" toProperty message,
        "duration" toProperty durationMs
    )
}