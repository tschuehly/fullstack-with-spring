package de.tschuehly.fullstackdemo.web.form.content

import de.tschuehly.fullstackdemo.web.form.content.Content
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

fun interface RenderFunction {
    fun render(content: Content): ViewContext
}
