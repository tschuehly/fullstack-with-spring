package de.tschuehly.fullstackdemo.web.page.form

import de.tschuehly.fullstackdemo.web.component.person.form.PersonFormViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class FormViewComponent(
    private val personFormViewComponent: PersonFormViewComponent
) {
    fun render() = FormCtx(
        personFormViewComponent.render()
    )

    data class FormCtx(val personFormViewComponent: ViewContext) : ViewContext
}