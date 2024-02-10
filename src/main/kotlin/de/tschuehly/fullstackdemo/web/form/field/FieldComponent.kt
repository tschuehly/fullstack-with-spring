package de.tschuehly.fullstackdemo.web.form.field

import de.tschuehly.fullstackdemo.web.form.Content
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

interface FieldComponent {
    fun canHandle(type: FieldType): Boolean
    fun render(content: Content): ViewContext
}
