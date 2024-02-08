package de.tschuehly.fullstackdemo.web.form.layout.box

import de.tschuehly.fullstackdemo.web.form.content.Content
import de.tschuehly.fullstackdemo.web.form.layout.LayoutComponent
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import java.util.function.Function

@ViewComponent
class BoxComponent : LayoutComponent {
    override fun canHandle(definition: LayoutDefinition<*>?): Boolean {
        return definition is BoxLayoutDefinition
    }

    override fun render(
        definition: LayoutDefinition<*>?,
        renderContent: Function<Content, ViewContext?>?
    ): ViewContext {
        val modalDefinition = definition as BoxLayoutDefinition?
        return BoxContent(modalDefinition, renderContent)
    }

    @JvmRecord
    data class BoxContent(
        val definition: BoxLayoutDefinition?,
        val renderContent: Function<Content, ViewContext?>?
    ) : ViewContext
}
