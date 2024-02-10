package de.tschuehly.fullstackdemo.web.form.layout

import de.tschuehly.fullstackdemo.web.form.RenderFunction
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

interface LayoutComponent {
    fun canHandle(definition: LayoutDefinition): Boolean
    fun render(definition: LayoutDefinition, renderContent: RenderFunction): ViewContext
}