package de.tschuehly.fullstackdemo.web.form

import de.tschuehly.fullstackdemo.web.form.field.FieldComponent
import de.tschuehly.fullstackdemo.web.form.field.FieldDefinition
import de.tschuehly.fullstackdemo.web.form.layout.LayoutComponent
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.springframework.stereotype.Service

@Service
class FormResolver(
    private val layoutComponents: List<LayoutComponent>,
    private val fieldComponents: List<FieldComponent>
) {

    fun render(content: Content): ViewContext {
        if (content is FieldDefinition) {
            val slotContentComponent = fieldComponents.stream()
                .filter { it: FieldComponent -> it.canHandle(content.fieldType) }
                .findFirst()
                .orElseThrow { RuntimeException("InvalidFormException") }
            return slotContentComponent.render(content)
        }
        if (content is LayoutDefinition) {
            val component = layoutComponents.stream()
                .filter { it: LayoutComponent -> it.canHandle(content) }.findFirst()
                .orElseThrow { RuntimeException("FormNotImplementedException") }
            return component.render(content, this::render)
        }
        throw RuntimeException("InvalidFormException")
    }
}
