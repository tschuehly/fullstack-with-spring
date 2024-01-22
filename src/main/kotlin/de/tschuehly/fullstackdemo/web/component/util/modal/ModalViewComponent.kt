package de.tschuehly.fullstackdemo.web.component.util.modal

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class ModalViewComponent {

    fun render(embeddedComponent: ViewContext) =
        ModalCtx(
            embeddedComponent
        )
    data class ModalCtx(val embeddedComponent:ViewContext):ViewContext
}