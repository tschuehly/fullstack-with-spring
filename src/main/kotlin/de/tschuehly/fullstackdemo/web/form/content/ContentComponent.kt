package de.tschuehly.fullstackdemo.web.form.content

import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

interface ContentComponent {
    fun canHandle(type: FieldType): Boolean

    fun render(content: Content): ViewContext
}
