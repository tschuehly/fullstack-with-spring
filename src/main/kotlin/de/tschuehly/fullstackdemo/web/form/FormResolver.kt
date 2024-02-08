package de.tschuehly.fullstackdemo.web.form

import de.tschuehly.fullstackdemo.web.form.content.Content
import de.tschuehly.fullstackdemo.web.form.content.ContentComponent
import de.tschuehly.fullstackdemo.web.form.content.FieldDefinition
import de.tschuehly.fullstackdemo.web.form.layout.LayoutComponent
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.springframework.stereotype.Service

@Service
class FormResolver(
    private val layoutComponents: List<LayoutComponent>,
    private val contentComponents: List<ContentComponent>
) {
    fun renderLayout(definition: LayoutDefinition<*>): ViewContext {
        val component = layoutComponents.stream()
            .filter { it: LayoutComponent -> it.canHandle(definition) }.findFirst()
            .orElseThrow { RuntimeException("FormNotImplementedException") }
        return component.render(definition) { content: Content -> this.renderSlot(content) }
    }

    fun renderSlot(content: Content): ViewContext {
        if (content is FieldDefinition) {
            val slotContentComponent = contentComponents.stream()
                .filter { it: ContentComponent -> it.canHandle(content.fieldType) }
                .findFirst()
                .orElseThrow { RuntimeException("InvalidFormException") }
            return slotContentComponent.render(content)
        }
        if (content is LayoutDefinition<*>) {
            return renderLayout(content)
        }
        throw RuntimeException("InvalidFormException")
    }
}
