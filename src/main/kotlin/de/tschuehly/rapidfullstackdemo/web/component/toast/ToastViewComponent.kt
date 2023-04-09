package de.tschuehly.rapidfullstackdemo.web.component.toast

import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class ToastViewComponent {
    fun render(message: String, durationMs: Int) = ViewContext(
        "message" toProperty message,
        "duration" toProperty durationMs
    )
}