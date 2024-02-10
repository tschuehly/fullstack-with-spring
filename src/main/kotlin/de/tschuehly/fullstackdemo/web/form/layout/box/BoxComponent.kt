package de.tschuehly.fullstackdemo.web.form.layout.box

import de.tschuehly.fullstackdemo.web.form.RenderFunction
import de.tschuehly.fullstackdemo.web.form.layout.LayoutComponent
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
class BoxComponent : LayoutComponent {
    override fun canHandle(definition: LayoutDefinition): Boolean {
        return definition is BoxDefinition
    }

    override fun render(definition: LayoutDefinition, renderContent: RenderFunction): ViewContext {
        return BoxContent(definition as BoxDefinition, renderContent)
    }

    data class BoxContent(
        val definition: BoxDefinition,
        val renderFunction: RenderFunction
    ) : ViewContext
}
