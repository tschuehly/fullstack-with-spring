package de.tschuehly.fullstackdemo.web.form.content.button

import de.tschuehly.fullstackdemo.web.form.content.Content
import de.tschuehly.fullstackdemo.web.form.content.ContentComponent
import de.tschuehly.fullstackdemo.web.form.content.FieldType
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class ButtonComponent : ContentComponent {
    override fun canHandle(type: FieldType): Boolean {
        return FieldType.BUTTON == type
    }

    override fun render(content: Content): ViewContext {
        val button = content as Button
        return ButtonContext(button)
    }

    @JvmRecord
    private data class ButtonContext(val button: Button) : ViewContext
}
