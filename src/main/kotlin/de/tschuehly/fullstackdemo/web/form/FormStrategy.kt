package de.tschuehly.fullstackdemo.web.form

import de.tschuehly.fullstackdemo.web.form.field.FieldComponent
import de.tschuehly.fullstackdemo.web.form.field.FieldDefinition
import de.tschuehly.fullstackdemo.web.form.layout.LayoutComponent
import de.tschuehly.fullstackdemo.web.form.layout.LayoutDefinition
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.springframework.stereotype.Service

@Service
class FormStrategy(
    private val layoutComponents: List<LayoutComponent>,
    private val fieldComponents: List<FieldComponent>
) {


    fun render(content: Content): ViewContext {
        if (content is FieldDefinition) {
            val fieldComponent = fieldComponents
                .firstOrNull { it.canHandle(content.fieldType) }
                ?: throw RuntimeException("FormNotImplementedException")
            return fieldComponent.render(content)
        }
        if (content is LayoutDefinition) {
            val layoutComponent = layoutComponents
                .stream()
                .filter { it.canHandle(content) }
                .findFirst()
                .orElseThrow { RuntimeException("FormNotImplementedException") }
            return layoutComponent.render(content, this::render)
        }
        throw RuntimeException("InvalidFormException")
    }
}
