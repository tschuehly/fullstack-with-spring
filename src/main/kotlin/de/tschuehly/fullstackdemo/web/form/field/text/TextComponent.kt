package de.tschuehly.fullstackdemo.web.form.field.text

import de.tschuehly.fullstackdemo.web.form.Content
import de.tschuehly.fullstackdemo.web.form.field.FieldComponent
import de.tschuehly.fullstackdemo.web.form.field.FieldType
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class TextComponent : FieldComponent {
    override fun canHandle(type: FieldType): Boolean {
        return FieldType.TEXT == type
    }

    override fun render(content: Content): ViewContext {
        val text = content as Text
        return TextContext(text)
    }

    data class TextContext(val text: Text) : ViewContext
}