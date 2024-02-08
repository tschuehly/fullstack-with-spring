package de.tschuehly.fullstackdemo.web.form.layout

import de.tschuehly.fullstackdemo.web.form.content.Content
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import java.util.function.Function

interface LayoutComponent {
    fun canHandle(definition: LayoutDefinition<*>?): Boolean

    fun render(definition: LayoutDefinition<*>?, renderContent: Function<Content, ViewContext?>?): ViewContext
}