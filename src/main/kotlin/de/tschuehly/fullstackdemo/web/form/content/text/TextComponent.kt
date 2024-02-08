package de.tschuehly.fullstackdemo.web.form.content.text

import de.tschuehly.fullstackdemo.web.form.content.Content
import de.tschuehly.fullstackdemo.web.form.content.ContentComponent
import de.tschuehly.fullstackdemo.web.form.content.FieldType
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class TextComponent : ContentComponent {
    override fun canHandle(type: FieldType): Boolean {
        return FieldType.TEXT == type
    }

    override fun render(content: Content): ViewContext {
        val text = content as Text
        return TextContext(text)
    }

    @JvmRecord
    private data class TextContext(val text: Text) : ViewContext
}