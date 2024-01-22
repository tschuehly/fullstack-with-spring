package de.tschuehly.fullstackdemo.web.component.util.toast

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class ToastViewComponent {
    fun render(message: String, durationMs: Int) = ToastCtx(
        message,
        durationMs
    )

    data class ToastCtx(
        val message: String,
        val duration: Int
    ) : ViewContext
}