package de.tschuehly.rapidfullstackdemo.web.component.util.modal

import de.tschuehly.spring.viewcomponent.core.ViewComponent
import de.tschuehly.spring.viewcomponent.core.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class ModalViewComponent {

    fun render(embeddedComponent: String) =
        ViewContext(
            "embeddedComponent" toProperty embeddedComponent
        )
}