package de.tschuehly.rapidfullstackdemo.web.component.util.toast

import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class ToastViewComponent {
    fun render(message: String, durationMs: Int) = ViewContext(
        "message" toProperty message,
        "duration" toProperty durationMs
    )
}