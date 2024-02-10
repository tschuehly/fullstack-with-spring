package de.tschuehly.fullstackdemo.web.form.layout.box

import de.tschuehly.fullstackdemo.web.form.RenderFunction
import de.tschuehly.fullstackdemo.web.form.layout.LayoutComponent
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class BoxComponent : LayoutComponent {
    override fun canHandle(definition: LayoutDefinition): Boolean {
        return definition is Box
    }

    override fun render(definition: LayoutDefinition, renderContent: RenderFunction): ViewContext {
        return BoxContent(definition as Box, renderContent)
    }

    data class BoxContent(
        val definition: Box,
        val renderFunction: RenderFunction
    ) : ViewContext
}
