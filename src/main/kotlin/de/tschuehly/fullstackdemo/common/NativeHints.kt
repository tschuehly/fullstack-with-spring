package de.tschuehly.fullstackdemo.common

import de.tschuehly.fullstackdemo.web.component.person.form.PersonFormViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import org.springframework.aot.hint.BindingReflectionHintsRegistrar
import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportRuntimeHints
import org.springframework.core.type.filter.AssignableTypeFilter

/**
 * GraalVM native hints (runs at AOT build time):
 * - ViewComponent templates live next to the classes, outside classpath:/templates
 * - Thymeleaf/SpEL reads ViewContext properties reflectively
 * - the PUT form binds PersonFormDTO via its Kotlin constructor
 */
@Configuration(proxyBeanMethods = false)
@ImportRuntimeHints(NativeHints::class)
class NativeHints : RuntimeHintsRegistrar {
    override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {
        hints.resources().registerPattern("de/tschuehly/fullstackdemo/**/*.html")

        val scanner = ClassPathScanningCandidateComponentProvider(false).apply {
            addIncludeFilter(AssignableTypeFilter(ViewContext::class.java))
        }
        val contexts = scanner.findCandidateComponents("de.tschuehly.fullstackdemo")
            .map { Class.forName(it.beanClassName, false, classLoader) }
        BindingReflectionHintsRegistrar().registerReflectionHints(
            hints.reflection(), *(contexts + PersonFormViewComponent.PersonFormDTO::class.java).toTypedArray()
        )
    }
}
