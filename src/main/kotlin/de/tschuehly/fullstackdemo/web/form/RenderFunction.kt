package de.tschuehly.fullstackdemo.web.form

import de.tschuehly.fullstackdemo.web.form.Content
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

fun interface RenderFunction {
    fun render(content: Content): ViewContext
}
