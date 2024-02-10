package de.tschuehly.fullstackdemo.web.form.field.button

import de.tschuehly.fullstackdemo.web.form.Content
import de.tschuehly.fullstackdemo.web.form.field.FieldComponent
import de.tschuehly.fullstackdemo.web.form.field.FieldType
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class ButtonComponent : FieldComponent {
    override fun canHandle(type: FieldType): Boolean {
        return FieldType.BUTTON == type
    }

    override fun render(content: Content): ViewContext {
        val button = content as Button
        return ButtonContext(button)
    }

    data class ButtonContext(val button: Button) : ViewContext
}
