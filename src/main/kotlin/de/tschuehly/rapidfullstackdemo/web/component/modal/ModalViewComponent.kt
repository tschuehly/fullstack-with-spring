package de.tschuehly.rapidfullstackdemo.web.component.modal

import de.tschuehly.thymeleafviewcomponent.ViewComponent
import de.tschuehly.thymeleafviewcomponent.ViewContext
import de.tschuehly.thymeleafviewcomponent.toProperty

@ViewComponent
class ModalViewComponent {

    fun render(embeddedComponent: String) =
        ViewContext(
            "embeddedComponent" toProperty embeddedComponent
        )
}